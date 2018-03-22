package com.domobile.dimobile_test.rate_exchange.beans;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 21:48
 *  @描述：    汇率请求bean
 */
public class RateExchangeBeans {
    /**
     * base : EUR
     * date : 2018-03-20
     * rates : {"AUD":1.5934,"BGN":1.9558,"BRL":4.041,"CAD":1.604,"CHF":1.1721,"CNY":7.7744,"CZK":25.423,"DKK":7.4485,"GBP":0.87715,"HKD":9.6295,"HRK":7.4423,"HUF":311.13,"IDR":16893,"ILS":4.2741,"INR":80.037,"ISK":122.5,"JPY":130.72,"KRW":1314.9,"MXN":23.009,"MYR":4.8091,"NOK":9.4863,"NZD":1.7039,"PHP":63.926,"PLN":4.2277,"RON":4.6663,"RUB":70.847,"SEK":10.056,"SGD":1.6174,"THB":38.301,"TRY":4.8238,"USD":1.2276,"ZAR":14.679}
     */

    private String base;
    private String    date;
    private RatesBean rates;

    public String getBase() { return base;}

    public void setBase(String base) { this.base = base;}

    public String getDate() { return date;}

    public void setDate(String date) { this.date = date;}

    public RatesBean getRates() { return rates;}

    public void setRates(RatesBean rates) { this.rates = rates;}

    public static class RatesBean {
        /**
         * AUD : 1.5934
         * BGN : 1.9558
         * BRL : 4.041
         * CAD : 1.604
         * CHF : 1.1721
         * CNY : 7.7744
         * CZK : 25.423
         * DKK : 7.4485
         * GBP : 0.87715
         * HKD : 9.6295
         * HRK : 7.4423
         * HUF : 311.13
         * IDR : 16893.0
         * ILS : 4.2741
         * INR : 80.037
         * ISK : 122.5
         * JPY : 130.72
         * KRW : 1314.9
         * MXN : 23.009
         * MYR : 4.8091
         * NOK : 9.4863
         * NZD : 1.7039
         * PHP : 63.926
         * PLN : 4.2277
         * RON : 4.6663
         * RUB : 70.847
         * SEK : 10.056
         * SGD : 1.6174
         * THB : 38.301
         * TRY : 4.8238
         * USD : 1.2276
         * ZAR : 14.679
         */

        private double AUD = 0;
        private double BGN = 0;
        private double BRL = 0;
        private double CAD = 0;
        private double CHF = 0;
        private double CNY = 0;
        private double CZK = 0;
        private double DKK = 0;
        private double GBP = 0;
        private double HKD = 0;
        private double HRK = 0;
        private double HUF = 0;
        private double IDR = 0;
        private double ILS = 0;
        private double INR = 0;
        private double ISK = 0;
        private double JPY = 0;
        private double KRW = 0;
        private double MXN = 0;
        private double MYR = 0;
        private double NOK = 0;
        private double NZD = 0;
        private double PHP = 0;
        private double PLN = 0;
        private double RON = 0;
        private double RUB = 0;
        private double SEK = 0;
        private double SGD = 0;
        private double THB = 0;
        private double TRY = 0;
        private double USD = 0;
        private double ZAR = 0;

        public double getAUD() { return AUD;}

        public void setAUD(double AUD) { this.AUD = AUD;}

        public double getBGN() { return BGN;}

        public void setBGN(double BGN) { this.BGN = BGN;}

        public double getBRL() { return BRL;}

        public void setBRL(double BRL) { this.BRL = BRL;}

        public double getCAD() { return CAD;}

        public void setCAD(double CAD) { this.CAD = CAD;}

        public double getCHF() { return CHF;}

        public void setCHF(double CHF) { this.CHF = CHF;}

        public double getCNY() { return CNY;}

        public void setCNY(double CNY) { this.CNY = CNY;}

        public double getCZK() { return CZK;}

        public void setCZK(double CZK) { this.CZK = CZK;}

        public double getDKK() { return DKK;}

        public void setDKK(double DKK) { this.DKK = DKK;}

        public double getGBP() { return GBP;}

        public void setGBP(double GBP) { this.GBP = GBP;}

        public double getHKD() { return HKD;}

        public void setHKD(double HKD) { this.HKD = HKD;}

        public double getHRK() { return HRK;}

        public void setHRK(double HRK) { this.HRK = HRK;}

        public double getHUF() { return HUF;}

        public void setHUF(double HUF) { this.HUF = HUF;}

        public double getIDR() { return IDR;}

        public void setIDR(double IDR) { this.IDR = IDR;}

        public double getILS() { return ILS;}

        public void setILS(double ILS) { this.ILS = ILS;}

        public double getINR() { return INR;}

        public void setINR(double INR) { this.INR = INR;}

        public double getISK() { return ISK;}

        public void setISK(double ISK) { this.ISK = ISK;}

        public double getJPY() { return JPY;}

        public void setJPY(double JPY) { this.JPY = JPY;}

        public double getKRW() { return KRW;}

        public void setKRW(double KRW) { this.KRW = KRW;}

        public double getMXN() { return MXN;}

        public void setMXN(double MXN) { this.MXN = MXN;}

        public double getMYR() { return MYR;}

        public void setMYR(double MYR) { this.MYR = MYR;}

        public double getNOK() { return NOK;}

        public void setNOK(double NOK) { this.NOK = NOK;}

        public double getNZD() { return NZD;}

        public void setNZD(double NZD) { this.NZD = NZD;}

        public double getPHP() { return PHP;}

        public void setPHP(double PHP) { this.PHP = PHP;}

        public double getPLN() { return PLN;}

        public void setPLN(double PLN) { this.PLN = PLN;}

        public double getRON() { return RON;}

        public void setRON(double RON) { this.RON = RON;}

        public double getRUB() { return RUB;}

        public void setRUB(double RUB) { this.RUB = RUB;}

        public double getSEK() { return SEK;}

        public void setSEK(double SEK) { this.SEK = SEK;}

        public double getSGD() { return SGD;}

        public void setSGD(double SGD) { this.SGD = SGD;}

        public double getTHB() { return THB;}

        public void setTHB(double THB) { this.THB = THB;}

        public double getTRY() { return TRY;}

        public void setTRY(double TRY) { this.TRY = TRY;}

        public double getUSD() { return USD;}

        public void setUSD(double USD) { this.USD = USD;}

        public double getZAR() { return ZAR;}

        public void setZAR(double ZAR) { this.ZAR = ZAR;}
    }
}
