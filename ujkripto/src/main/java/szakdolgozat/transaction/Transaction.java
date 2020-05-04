package szakdolgozat.transaction;

import java.util.ArrayList;
import java.util.Objects;

public class Transaction {
    private long timeStamp;
    private String sender;
    private String receiver;
    private double amount;
    private String signature;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return getTimeStamp() == that.getTimeStamp() &&
                Double.compare(that.getAmount(), getAmount()) == 0 &&
                getSender().equals(that.getSender()) &&
                getReceiver().equals(that.getReceiver()) &&
                getSignature().equals(that.getSignature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimeStamp(), getSender(), getReceiver(), getAmount());
    }

    public ArrayList<String> oarseDataAsStringList() {
        ArrayList<String> dataAsStringList = new ArrayList<>();
        dataAsStringList.add(String.valueOf(timeStamp));
        dataAsStringList.add(sender);
        dataAsStringList.add(receiver);
        dataAsStringList.add(String.valueOf(amount));
        dataAsStringList.add(signature);
        return dataAsStringList;
    }
}
