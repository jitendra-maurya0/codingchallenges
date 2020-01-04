package com.sample.question.annonymus;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stock {


    public static double calculalteHoldings(String date){
        Map<String,Double> holdings =getHolding(date);
        Map<String,Double> currentPrice = getPrice(date);
        Double currentHolding =0.0;
        for (Map.Entry<String,Double>entry:holdings.entrySet()){
            currentHolding = currentHolding+currentPrice.get(entry.getKey())*entry.getValue();
        }
        return currentHolding;
    }


    public static Map<String,Double> getHolding(String date){
        String url = "https://api.myjson.com/bins/10ysxg";
         Map<String,Double> holdings = new HashMap<>();
        try {

            while (url != null) {
                URL uri = new URL(url);
                InputStream input = uri.openStream();
                Reader reader = new InputStreamReader(input, "UTF-8");
                HoldingResponse result = new Gson().fromJson(reader, HoldingResponse.class);
                List<Security> portfolio = result.getData().stream().filter(seq->seq.getDate().equals(date)).collect(Collectors.toList());
                for(Security d: portfolio){
                    double qty = d.getQuantity();
                    if(holdings.containsKey(d.getSecurity())){
                        double prevHolding = holdings.get(d.getSecurity());
                        qty = qty+prevHolding;
                    }
                     holdings.put(d.getSecurity(),qty);
                }
                url = result.nextPage;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return holdings;
    }

    public static Map<String,Double> getPrice(String date){
        String url = "https://api.myjson.com/bins/6ycbo";
        Map<String,Double> priceMap = new HashMap<>();
        try {

            while (url != null) {
                URL uri = new URL(url);
                InputStream input = uri.openStream();
                Reader reader = new InputStreamReader(input, "UTF-8");
                PriceResponse result = new Gson().fromJson(reader, PriceResponse.class);
                List<Price> portfolio = result.getData().stream().filter(price->price.getDate().equals(date)).collect(Collectors.toList());
                for(Price d: portfolio){
                    double price = d.getPrice();
                    if(priceMap.containsKey(d.getSecurity())){
                        double prevHolding = priceMap.get(d.getSecurity());
                        price = price+prevHolding;
                    }
                    priceMap.put(d.getSecurity(),price);
                }
                url = result.nextPage;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return priceMap;
    }

    class Security{
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("security")
        @Expose
        private String security;
        @SerializedName("quantity")
        @Expose
        private Double quantity;
        @SerializedName("portfolio")
        @Expose
        private String portfolio;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
        }

        public Double getQuantity() {
            return quantity;
        }

        public void setQuantity(Double quantity) {
            this.quantity = quantity;
        }

        public String getPortfolio() {
            return portfolio;
        }

        public void setPortfolio(String portfolio) {
            this.portfolio = portfolio;
        }


    }

    class Price{
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("security")
        @Expose
        private String security;
        @SerializedName("price")
        @Expose
        private Double price;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }


    }
    class HoldingResponse{
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("nextPage")
        @Expose
        private String nextPage;
        @SerializedName("recordsPerPage")
        @Expose
        private Integer recordsPerPage;
        @SerializedName("totalRecords")
        @Expose
        private Integer totalRecords;
        @SerializedName("data")
        @Expose
        private List<Security> data = null;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
            this.nextPage = nextPage;
        }

        public Integer getRecordsPerPage() {
            return recordsPerPage;
        }

        public void setRecordsPerPage(Integer recordsPerPage) {
            this.recordsPerPage = recordsPerPage;
        }

        public Integer getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(Integer totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<Security> getData() {
            return data;
        }

        public void setData(List<Security> data) {
            this.data = data;
        }
    }

    class PriceResponse{
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("nextPage")
        @Expose
        private String nextPage;
        @SerializedName("recordsPerPage")
        @Expose
        private Integer recordsPerPage;
        @SerializedName("totalRecords")
        @Expose
        private Integer totalRecords;
        @SerializedName("data")
        @Expose
        private List<Price> data = null;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
            this.nextPage = nextPage;
        }

        public Integer getRecordsPerPage() {
            return recordsPerPage;
        }

        public void setRecordsPerPage(Integer recordsPerPage) {
            this.recordsPerPage = recordsPerPage;
        }

        public Integer getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(Integer totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<Price> getData() {
            return data;
        }

        public void setData(List<Price> data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
       // stock.getHolding("20190506");
        System.out.println( stock.calculalteHoldings("20190506"));
    }
}
