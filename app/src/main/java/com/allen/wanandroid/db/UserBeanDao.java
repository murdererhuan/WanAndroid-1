package com.allen.wanandroid.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.List;

import com.allen.wanandroid.bean.UserBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_BEAN".
*/
public class UserBeanDao extends AbstractDao<UserBean, Long> {

    public static final String TABLENAME = "USER_BEAN";

    /**
     * Properties of entity UserBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Email = new Property(0, String.class, "email", false, "EMAIL");
        public final static Property Icon = new Property(1, String.class, "icon", false, "ICON");
        public final static Property Id = new Property(2, Long.class, "id", true, "_id");
        public final static Property Password = new Property(3, String.class, "password", false, "PASSWORD");
        public final static Property Type = new Property(4, int.class, "type", false, "TYPE");
        public final static Property Username = new Property(5, String.class, "username", false, "USERNAME");
        public final static Property CollectIds = new Property(6, String.class, "collectIds", false, "COLLECT_IDS");
    }

    private final StringConverter collectIdsConverter = new StringConverter();

    public UserBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UserBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_BEAN\" (" + //
                "\"EMAIL\" TEXT," + // 0: email
                "\"ICON\" TEXT," + // 1: icon
                "\"_id\" INTEGER PRIMARY KEY ," + // 2: id
                "\"PASSWORD\" TEXT," + // 3: password
                "\"TYPE\" INTEGER NOT NULL ," + // 4: type
                "\"USERNAME\" TEXT," + // 5: username
                "\"COLLECT_IDS\" TEXT);"); // 6: collectIds
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(1, email);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(2, icon);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(3, id);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
        stmt.bindLong(5, entity.getType());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(6, username);
        }
 
        List collectIds = entity.getCollectIds();
        if (collectIds != null) {
            stmt.bindString(7, collectIdsConverter.convertToDatabaseValue(collectIds));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(1, email);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(2, icon);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(3, id);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
        stmt.bindLong(5, entity.getType());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(6, username);
        }
 
        List collectIds = entity.getCollectIds();
        if (collectIds != null) {
            stmt.bindString(7, collectIdsConverter.convertToDatabaseValue(collectIds));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2);
    }    

    @Override
    public UserBean readEntity(Cursor cursor, int offset) {
        UserBean entity = new UserBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // email
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // icon
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // password
            cursor.getInt(offset + 4), // type
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // username
            cursor.isNull(offset + 6) ? null : collectIdsConverter.convertToEntityProperty(cursor.getString(offset + 6)) // collectIds
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserBean entity, int offset) {
        entity.setEmail(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setIcon(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setPassword(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setType(cursor.getInt(offset + 4));
        entity.setUsername(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCollectIds(cursor.isNull(offset + 6) ? null : collectIdsConverter.convertToEntityProperty(cursor.getString(offset + 6)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
