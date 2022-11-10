package kz.iitu.itse1905.komekbay.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.*;
import java.io.Serializable;

class JMSConfigTest {
    JMSConfig jMSConfig = new JMSConfig();
    @Mock
    DefaultJmsListenerContainerFactoryConfigurer defaultJmsListenerContainerFactoryConfigurer = new DefaultJmsListenerContainerFactoryConfigurer();
    Connection connection = new Connection() {
        @Override
        public Session createSession(boolean b, int i) throws JMSException {
            return null;
        }

        @Override
        public Session createSession(int i) throws JMSException {
            return null;
        }

        @Override
        public Session createSession() throws JMSException {
            return null;
        }

        @Override
        public String getClientID() throws JMSException {
            return null;
        }

        @Override
        public void setClientID(String s) throws JMSException {

        }

        @Override
        public ConnectionMetaData getMetaData() throws JMSException {
            return null;
        }

        @Override
        public ExceptionListener getExceptionListener() throws JMSException {
            return null;
        }

        @Override
        public void setExceptionListener(ExceptionListener exceptionListener) throws JMSException {

        }

        @Override
        public void start() throws JMSException {

        }

        @Override
        public void stop() throws JMSException {

        }

        @Override
        public void close() throws JMSException {

        }

        @Override
        public ConnectionConsumer createConnectionConsumer(Destination destination, String s, ServerSessionPool serverSessionPool, int i) throws JMSException {
            return null;
        }

        @Override
        public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String s, String s1, ServerSessionPool serverSessionPool, int i) throws JMSException {
            return null;
        }

        @Override
        public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String s, String s1, ServerSessionPool serverSessionPool, int i) throws JMSException {
            return null;
        }

        @Override
        public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String s, String s1, ServerSessionPool serverSessionPool, int i) throws JMSException {
            return null;
        }
    };
    JMSContext jmsContext = new JMSContext() {
        @Override
        public JMSContext createContext(int i) {
            return null;
        }

        @Override
        public JMSProducer createProducer() {
            return null;
        }

        @Override
        public String getClientID() {
            return null;
        }

        @Override
        public void setClientID(String s) {

        }

        @Override
        public ConnectionMetaData getMetaData() {
            return null;
        }

        @Override
        public ExceptionListener getExceptionListener() {
            return null;
        }

        @Override
        public void setExceptionListener(ExceptionListener exceptionListener) {

        }

        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }

        @Override
        public void setAutoStart(boolean b) {

        }

        @Override
        public boolean getAutoStart() {
            return false;
        }

        @Override
        public void close() {

        }

        @Override
        public BytesMessage createBytesMessage() {
            return null;
        }

        @Override
        public MapMessage createMapMessage() {
            return null;
        }

        @Override
        public Message createMessage() {
            return null;
        }

        @Override
        public ObjectMessage createObjectMessage() {
            return null;
        }

        @Override
        public ObjectMessage createObjectMessage(Serializable serializable) {
            return null;
        }

        @Override
        public StreamMessage createStreamMessage() {
            return null;
        }

        @Override
        public TextMessage createTextMessage() {
            return null;
        }

        @Override
        public TextMessage createTextMessage(String s) {
            return null;
        }

        @Override
        public boolean getTransacted() {
            return false;
        }

        @Override
        public int getSessionMode() {
            return 0;
        }

        @Override
        public void commit() {

        }

        @Override
        public void rollback() {

        }

        @Override
        public void recover() {

        }

        @Override
        public JMSConsumer createConsumer(Destination destination) {
            return null;
        }

        @Override
        public JMSConsumer createConsumer(Destination destination, String s) {
            return null;
        }

        @Override
        public JMSConsumer createConsumer(Destination destination, String s, boolean b) {
            return null;
        }

        @Override
        public Queue createQueue(String s) {
            return null;
        }

        @Override
        public Topic createTopic(String s) {
            return null;
        }

        @Override
        public JMSConsumer createDurableConsumer(Topic topic, String s) {
            return null;
        }

        @Override
        public JMSConsumer createDurableConsumer(Topic topic, String s, String s1, boolean b) {
            return null;
        }

        @Override
        public JMSConsumer createSharedDurableConsumer(Topic topic, String s) {
            return null;
        }

        @Override
        public JMSConsumer createSharedDurableConsumer(Topic topic, String s, String s1) {
            return null;
        }

        @Override
        public JMSConsumer createSharedConsumer(Topic topic, String s) {
            return null;
        }

        @Override
        public JMSConsumer createSharedConsumer(Topic topic, String s, String s1) {
            return null;
        }

        @Override
        public QueueBrowser createBrowser(Queue queue) {
            return null;
        }

        @Override
        public QueueBrowser createBrowser(Queue queue, String s) {
            return null;
        }

        @Override
        public TemporaryQueue createTemporaryQueue() {
            return null;
        }

        @Override
        public TemporaryTopic createTemporaryTopic() {
            return null;
        }

        @Override
        public void unsubscribe(String s) {

        }

        @Override
        public void acknowledge() {

        }
    };
    ConnectionFactory connectionFactory = new ConnectionFactory() {
        @Override
        public Connection createConnection() throws JMSException {
            return connection;
        }

        @Override
        public Connection createConnection(String s, String s1) throws JMSException {
            return connection;
        }

        @Override
        public JMSContext createContext() {
            return jmsContext;
        }

        @Override
        public JMSContext createContext(String s, String s1) {
            return jmsContext;
        }

        @Override
        public JMSContext createContext(String s, String s1, int i) {
            return jmsContext;
        }

        @Override
        public JMSContext createContext(int i) {
            return jmsContext;
        }
    };

    @Test
    void testJacksonJmsMessageConverter() {
        MessageConverter result = jMSConfig.jacksonJmsMessageConverter();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme