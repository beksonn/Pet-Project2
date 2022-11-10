package kz.iitu.itse1905.komekbay.service;

import kz.iitu.itse1905.komekbay.model.*;
import kz.iitu.itse1905.komekbay.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.Message;
import java.util.List;

@org.springframework.stereotype.Service
@DependsOn({"Repository"})
public class Service {
    private final ConsumerRepository consumerRepository;
    private final RegionRepository regionRepository;
    private final DocRepository docRepository;
    private final BankAccountRepository bankAccountRepository;
    private final InspectorRepository inspectorRepository;
    private final MessageReciever messageReciever;
    private final MessageSender messageSender;

    @Autowired
    public Service(ConsumerRepository consumerRepository, RegionRepository regionRepository, DocRepository docRepository, BankAccountRepository bankAccountRepository, InspectorRepository inspectorRepository, MessageReciever messageReciever, MessageSender messageSender) {
        this.consumerRepository = consumerRepository;
        this.regionRepository = regionRepository;
        this.docRepository = docRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.inspectorRepository = inspectorRepository;
        this.messageReciever = messageReciever;
        this.messageSender = messageSender;
    }

    // -----------------------------------CONSUMER--------------------------------------------------//


    public List<Consumer> listAllConsumer(){
        return consumerRepository.listAllConsumers();
    }

    public String createConsumer(Consumer newConsumer){
        List<Region> regions = listAllRegion();
        String message= null;
        for (Region region : regions) {
            if (newConsumer.getRegion().equals(region.getName())) {
                List<Consumer> consumers = listAllConsumer();
                boolean bol=false;
                for(Consumer consumer: consumers)
                    if (consumer.getFirstName().equals(newConsumer.getFirstName()) && consumer.getLastName().equals((newConsumer.getLastName()))) {
                        bol = true;
                        break;
                    }


                if (bol){
                    message = "This consumer already exists";
                    break;
                }else {
                    message = consumerRepository.createConsumer(newConsumer);
                    List<Consumer> consumers2 = listAllConsumer();
                    List<BankAccount> bankAccounts = listAllBankAccount();
                    for (Consumer consumer2 : consumers2) {
                        if (newConsumer.getFirstName().equals(consumer2.getFirstName()) && newConsumer.getLastName().equals(consumer2.getLastName())) {
                            for (BankAccount bankAccount : bankAccounts) {
                                String fullName = consumer2.getFirstName() + consumer2.getLastName();
                                if (bankAccount.getOwnerFullName().equals(fullName)) {
                                    bankAccount.setOwnerPersonalAccount(consumer2.getPersonalAccount());
                                    bankAccountRepository.changeOwnerPersonalAccount(bankAccount);
                                }
                            }
                        }
                    }
                }

                break;
            }else message = "There is no like this Region";
        }

        return message;
    }

    public String updateConsumerById(Consumer updConsumer, int personalAccount){
        List<Region> regions = listAllRegion();
        String message= null;
        for (Region region : regions) {
            if (updConsumer.getRegion().equals(region.getName())) {
                message = consumerRepository.updateConsumerById(updConsumer, personalAccount);
                break;
            } else message = "There is no like this Region";
        }

        return message;
    }

    public String deleteConsumerByPersonalAccount(int personalAccount){
        return consumerRepository.deleteConsumerByPersonalAccount(personalAccount);
    }

    public List<Consumer> listConsumerByRegion(int id){
        List<Consumer> consumers = listAllConsumer();
        List<Region> regions = listAllRegion();


        for (Region region : regions)
            if (id == region.getId()){
                consumers.removeIf(consumer -> !region.getName().equals(consumer.getRegion()));
                break;
            }
        return consumers;
    }

    public String makeBillToConsumerByPersonalAccount(int personalAccount, float meterReading, String checkOrPay){
        List<Consumer> consumers = listAllConsumer();
        List<Region> regions = listAllRegion();

        float forPayment = 0;

        Consumer consumerWeNeed = null;

        for (Consumer consumer : consumers)
            if(consumer.getPersonalAccount() == personalAccount){
                consumerWeNeed = consumer;
                for (Region region : regions) if(consumer.getRegion().equals(region.getName())){
                    float actuallyReading = meterReading-consumer.getLastMeterReading();
                    if(actuallyReading>180){//350
                        forPayment = forPayment + (180*region.getFirstLvlPayment());//180*17.53
                        if(actuallyReading>320){//350
                            forPayment = forPayment + ((actuallyReading-320)*region.getThirdLvlPayment());//30*28.32
                            forPayment = forPayment + (140*region.getSecondLvlPayment());//140*22.66
                        }else forPayment = forPayment + ((actuallyReading-180)*region.getSecondLvlPayment());
                    }else forPayment = forPayment + (actuallyReading*region.getFirstLvlPayment());
                }
                break;
            }
        if(checkOrPay.equals("check")) {
            String messageForPayment = Float.toString(forPayment);
            return "For payment: " + messageForPayment;
        }else if(checkOrPay.equals("pay")){
            consumerRepository.changeLastMeterAfterBill(consumerWeNeed.getPersonalAccount(), meterReading);
            List<BankAccount> bankAccounts = listAllBankAccount();
            for(BankAccount bankAccount: bankAccounts) if(bankAccount.getOwnerPersonalAccount() == personalAccount) return bankAccountRepository.fillDownAfterPayment(bankAccount, forPayment, true);

        }
        return "You must write 'check' or 'pay' after personalAccount and meterReading";
    }



// -----------------------------------REGION--------------------------------------------------//
    public List<Region> listAllRegion(){
        return regionRepository.listAllRegion();
    }

    public String createRegion(Region newRegion){
        List<Region> regions = listAllRegion();
        String message;
        boolean bool = false;
        for (Region region : regions) {
            if (newRegion.getName().equals(region.getName())) {
                bool = true;
                break;
            }
        }
        if(bool){
            message = "This region already exists";
        }else message = regionRepository.createRegion(newRegion);
        return message;
    }

    public List<Region> listAllRegionWithPagination(int pageNO, int pageSize){
        Page<Region> pagedResult = regionRepository.findAllWithPagination(PageRequest.of(pageNO,pageSize));
        return pagedResult.toList();
    }


    // -----------------------------------DOC--------------------------------------------------//

    public void saveFile(MultipartFile file){
        String docname = file.getOriginalFilename();
        try{
            Doc doc = new Doc(docname,file.getContentType(),file.getBytes());
            docRepository.saveFile(doc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Doc getFile(Integer fileId){
        List<Doc> docs = getFiles();
        for(Doc doc: docs){
            if(doc.getId().equals(fileId)){
                return doc;
            }
        }
        return null;
    }
    public List<Doc> getFiles(){
        return docRepository.listAllDocs();
    }

    // -----------------------------------BANK_ACCOUNT--------------------------------------------------//
    public List<BankAccount> listAllBankAccount(){
        return bankAccountRepository.listAllBankAccount();
    }

    public String fillUpAccount(int personalAccount, float fillingMoney){
        List<BankAccount> bankAccounts = listAllBankAccount();
        for(BankAccount bankAccount: bankAccounts) if(bankAccount.getOwnerPersonalAccount() == personalAccount) return bankAccountRepository.fillUpAccount(bankAccount, fillingMoney);
        return "There is no like this Personal Account";
    }

    // -----------------------------------Inspector--------------------------------------------------//
    public List<Inspector> listAllInspector(){
        return inspectorRepository.listAllInspectors();
    }

    public String callInspector(int id){
        List<Inspector> inspectors = listAllInspector();

        String message = null;
        for(Inspector inspector: inspectors){
            if(inspector.getId()==id){
                if(inspector.isHeFree()){
                    message = "Inspector accepted, work will done after pay";
                    messageSender.sendMessage(inspector.getCostOfService());
                    return message;
                }else message = "This inspector is not free at this moment";
            }
        }


        return "There is no inspector with this ID";
    }

    public String payInspector(int personalAccount, int id, String checkOrPay) {
        int   forPayment = messageReciever.messageInQueue();
        if(checkOrPay.equals("pay")){
            List<Inspector> inspectors = listAllInspector();
            List<BankAccount> bankAccounts = listAllBankAccount();

            for(Inspector inspector: inspectors){
                if(inspector.getId()==id){
                    for(BankAccount bankAccount: bankAccounts){
                        if(bankAccount.getOwnerPersonalAccount()==personalAccount){
                            bankAccountRepository.fillDownAfterPayment(bankAccount,forPayment, false);
                            return forPayment + " you paid service";
                        }
                    }
                }
            }
        }

        return forPayment + " for payment";
    }

}
