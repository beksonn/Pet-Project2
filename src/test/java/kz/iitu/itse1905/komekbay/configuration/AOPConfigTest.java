package kz.iitu.itse1905.komekbay.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AOPConfigTest {
    AOPConfig aOPConfig = new AOPConfig();

    @Mock
    JoinPoint joinPoint = new JoinPoint() {
        @Override
        public String toShortString() {
            return "string";
        }

        @Override
        public String toLongString() {
            return "String";
        }

        @Override
        public Object getThis() {
            return null;
        }

        @Override
        public Object getTarget() {
            return null;
        }

        @Override
        public Object[] getArgs() {
            return new Object[0];
        }

        @Override
        public Signature getSignature() {
            Signature signature = new Signature() {
                @Override
                public String toShortString() {
                    return null;
                }

                @Override
                public String toLongString() {
                    return null;
                }

                @Override
                public String getName() {
                    return null;
                }

                @Override
                public int getModifiers() {
                    return 0;
                }

                @Override
                public Class getDeclaringType() {
                    return null;
                }

                @Override
                public String getDeclaringTypeName() {
                    return null;
                }
            };
            return signature;
        }

        @Override
        public SourceLocation getSourceLocation() {
            return null;
        }

        @Override
        public String getKind() {
            return "STRing";
        }

        @Override
        public StaticPart getStaticPart() {
            return null;
        }
    };

    @Test
    void testMethod1() {
        aOPConfig.method1();
    }

    @Test
    void testBeforeMethod1() {
        aOPConfig.beforeMethod1(joinPoint);
    }

    @Test
    void testAfterMethod1() {
        aOPConfig.afterMethod1(joinPoint);
    }

    @Test
    void testMethod2() {
        aOPConfig.method2();
    }

    @Test
    void testBeforeMethod2() {
        aOPConfig.beforeMethod2(joinPoint);
    }

    @Test
    void testAfterMethod2() {
        aOPConfig.afterMethod2(joinPoint);
    }

    @Test
    void testAfterThrowing() {
        aOPConfig.afterThrowing(joinPoint);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme