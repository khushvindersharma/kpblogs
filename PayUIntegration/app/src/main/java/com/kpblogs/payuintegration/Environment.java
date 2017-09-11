package com.kpblogs.payuintegration;

/**
 * Created by khushvinder
 */
public enum Environment {

    TEST {
        @Override
        public String merchant_Key() {
            return "LLKwG0";
        }

        @Override
        public String merchant_ID() {
            return "393463";
        }

        @Override
        public String furl() {
            return "https://www.payumoney.com/mobileapp/payumoney/failure.php";
        }

        @Override
        public String surl() {
            return "https://www.payumoney.com/mobileapp/payumoney/success.php";
        }

        @Override
        public boolean debug() {
            return true;
        }
    },
    PRODUCTION {
        @Override
        public String merchant_Key() {
            return "O15vkB";
        }

        @Override
        public String merchant_ID() {
            return "4819816";
        }

        @Override
        public String furl() {
            return "https://www.payumoney.com/mobileapp/payumoney/failure.php";
        }

        @Override
        public String surl() {
            return "https://www.payumoney.com/mobileapp/payumoney/success.php";
        }

        @Override
        public boolean debug() {
            return false;
        }
    };

    public abstract String merchant_Key();

    public abstract String merchant_ID();

    public abstract String furl();

    public abstract String surl();

    public abstract boolean debug();

}
