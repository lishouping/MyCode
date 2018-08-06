package mycode.com.mycode;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * UserInfo
 * (c)2018 AIR Times Inc. All rights reserved.
 *
 * @author Lishp
 * @version 1.0
 * @date 2018/8/4 13:15
 * @see
 */
@Entity
public class UserInfo implements Parcelable {
    @Id
    private Long id;
    private String name;
    @Generated(hash = 574809764)
    public UserInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(name);
    }
}
