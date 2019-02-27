package com.test.design.clone;

import com.test.annotation.IntDef;
import com.test.annotation.NonNull;
import com.test.annotation.Nullable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.test.design.clone.Intent.CopyMode.*;

public class Intent implements Cloneable {
    private String mAction;
    private String mType;
    private String mPackage;
    private Teacher mTeacher = new Teacher();

    public Intent() {


    }

    public Intent(Intent o) {
        this(o, COPY_MODE_ALL);
    }

    public Intent(Intent o, @CopyMode int mode) {
        this.mAction = o.mAction;
        this.mPackage = o.mPackage;
        if (mode == COPY_MODE_FILTER) {
            this.mType = o.mType;
        }
        if (o.mTeacher != null) {
            try {
                this.mTeacher = o.mTeacher.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    public @NonNull
    Intent setAction(@Nullable String action) {
        mAction = action != null ? action.intern() : null;
        return this;
    }

    public Intent setPackage(@Nullable String pkg) {
        mPackage = pkg != null ? pkg.intern() : null;
        return this;
    }

    public Intent setTeacher(@Nullable Teacher teacher) {
        mTeacher = teacher;
        return this;
    }

    public Intent setTeacher(String name, int age) {
        mTeacher.setName(name);
        mTeacher.setAge(age);
        return this;
    }
    public @NonNull
    Intent setType(@Nullable String type) {
        mType = type != null ? type.intern() : null;
        return this;
    }

    @IntDef(prefix = {"COPY_MODE_"}, value = {
            COPY_MODE_ALL,
            COPY_MODE_FILTER,
            COPY_MODE_HISTORY
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface CopyMode {
        int COPY_MODE_ALL = 0;
        int COPY_MODE_FILTER = 1;
        int COPY_MODE_HISTORY = 2;
    }

    @Override
    protected Intent clone() {
        return new Intent(this);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(128);
        b.append("Intent{")
                .append("action=")
                .append(mAction)
                .append(" ")
                .append("package=")
                .append(mPackage);
        if (mType != null) {
            b.append(" ").append("type=").append(mType);
        }
        if (mTeacher != null) {
            b.append(" ").append("[").append(mTeacher.toString()).append("]");
        }
        b.append("}");
        return b.toString();
    }
}
