package blackout.storage;

import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;

import org.jboss.logging.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserAdapter extends AbstractUserAdapterFederatedStorage
{
    private static final Logger logger = Logger.getLogger(UserAdapter.class);
    protected UserEntity entity;
    protected  String keycloakId;

    public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, UserEntity entity) {
        super(session, realm, model);

        this.entity = entity;
        keycloakId = storageId.keycloakId(model, entity.getId());
    }

    public void setPassword(String s)
    {
        entity.setPassword(s);
    }

    public String getPassword()
    {
        return entity.getPassword();
    }

    @Override
    public String getUsername()
    {
        return entity.getUsername();
    }

    @Override
    public void setUsername(String s)
    {
         entity.setUsername(s);
    }

    @Override
    public String getEmail()
    {
        return entity.getEmail();
    }

    @Override
    public void setEmail(String s)
    {
        entity.setEmail(s);
    }

    @Override
    public String getId()
    {
        return entity.getId();
    }

    @Override
    public void setSingleAttribute(String name, String value)
    {
        if(name.equals("phone")) {
            entity.setPhone(value);
        } else {
            super.setSingleAttribute(name, value);
        }
    }

    @Override
    public void removeAttribute(String name)
    {
        if(name.equals("phone")) {
            entity.setPhone(null);
        } else {
            super.removeAttribute(name);
        }
    }

    @Override
    public void setAttribute(String name, List<String> values)
    {
        if(name.equals("phone")) {
            entity.setPhone(values.get(0));
        } else {
            super.setAttribute(name, values);
        }
    }

    @Override
    public String getFirstAttribute(String name)
    {
        if(name.equals("phone")) {
            return entity.getPhone();
        } else {
            return super.getFirstAttribute(name);
        }
    }

    @Override
    public Map<String, List<String>> getAttributes()
    {
        Map<String, List<String>> attrs = super.getAttributes();
        MultivaluedHashMap<String, String> all = new MultivaluedHashMap<>();
        all.putAll(attrs);
        all.add("phone", entity.getPhone());
        return all;
    }

    @Override
    public List<String> getAttribute(String name)
    {
        if(name.equals("phone")){
            List<String> phone = new LinkedList<>();
            phone.add(entity.getPhone());
            return phone;
        } else {
            return super.getAttribute(name);
        }
    }

}
