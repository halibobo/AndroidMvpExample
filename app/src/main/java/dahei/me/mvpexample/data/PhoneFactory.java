package dahei.me.mvpexample.data;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

/**
 * Created by su on 2016/6/22.
 */

/**
 * 手机工厂类
 */
public class PhoneFactory {

    private ArrayList<Phone> phonesList = new ArrayList<>();


    public void addPhone(Phone phone) {
        phonesList.add(phone);
    }

    public void removePhone(Phone phone) {
        phonesList.remove(phone);
    }

    public void removePhone(int index) {
        if (index >= 0 && index < phonesList.size()) {
            phonesList.remove(index);
        }
    }

    public void createPhone(String name, double price) {
        Phone phone = new Phone(name, price);
        phonesList.add(phone);
    }

    public ArrayList<Phone> getPhonesList() {
        return phonesList;
    }

    public int getPhoneCounts() {
        return phonesList.size();
    }

}
