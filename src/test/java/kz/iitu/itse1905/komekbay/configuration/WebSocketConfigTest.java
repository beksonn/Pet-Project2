package kz.iitu.itse1905.komekbay.configuration;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.SockJsServiceRegistration;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebMvcStompEndpointRegistry;
import org.springframework.web.socket.messaging.StompSubProtocolErrorHandler;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.UrlPathHelper;

class WebSocketConfigTest {
    WebSocketConfig webSocketConfig = new WebSocketConfig();
    MessageChannel messageChannel = new MessageChannel() {
        @Override
        public boolean send(Message<?> message, long l) {
            return false;
        }
    };
    SubscribableChannel subscribableChannel = new SubscribableChannel() {
        @Override
        public boolean subscribe(MessageHandler messageHandler) {
            return false;
        }

        @Override
        public boolean unsubscribe(MessageHandler messageHandler) {
            return false;
        }

        @Override
        public boolean send(Message<?> message, long l) {
            return false;
        }
    };
    @Mock
    MessageBrokerRegistry messageBrokerRegistry = new MessageBrokerRegistry(subscribableChannel,messageChannel);

    StompEndpointRegistry stompEndpointRegistry = new StompEndpointRegistry() {
        @Override
        public StompWebSocketEndpointRegistration addEndpoint(String... strings) {
            StompWebSocketEndpointRegistration stompWebSocketEndpointRegistration = new StompWebSocketEndpointRegistration() {
                @Override
                public SockJsServiceRegistration withSockJS() {
                    return null;
                }

                @Override
                public StompWebSocketEndpointRegistration setHandshakeHandler(HandshakeHandler handshakeHandler) {
                    return null;
                }

                @Override
                public StompWebSocketEndpointRegistration addInterceptors(HandshakeInterceptor... handshakeInterceptors) {
                    return null;
                }

                @Override
                public StompWebSocketEndpointRegistration setAllowedOrigins(String... strings) {
                    return null;
                }
            };
            return stompWebSocketEndpointRegistration;
        }

        @Override
        public void setOrder(int i) {

        }

        @Override
        public void setUrlPathHelper(UrlPathHelper urlPathHelper) {

        }

        @Override
        public WebMvcStompEndpointRegistry setErrorHandler(StompSubProtocolErrorHandler stompSubProtocolErrorHandler) {
            return null;
        }
    };


    @Test
    void testConfigureMessageBroker() {
        webSocketConfig.configureMessageBroker(messageBrokerRegistry);
    }

    @Test
    void testRegisterStompEndpoints() {
        webSocketConfig.registerStompEndpoints(stompEndpointRegistry);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme