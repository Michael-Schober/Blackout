package blackout.dbconnector.model;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.*;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class UserAdapter extends UserModel
{

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void setUsername(String s) {

    }

    @Override
    public Long getCreatedTimestamp() {
        return null;
    }

    @Override
    public void setCreatedTimestamp(Long aLong) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isOtpEnabled() {
        return false;
    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public void setSingleAttribute(String s, String s1) {

    }

    @Override
    public void setAttribute(String s, List<String> list) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public String getFirstAttribute(String s) {
        return null;
    }

    @Override
    public List<String> getAttribute(String s) {
        return null;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        return null;
    }

    @Override
    public Set<String> getRequiredActions() {
        return null;
    }

    @Override
    public void addRequiredAction(String s) {

    }

    @Override
    public void removeRequiredAction(String s) {

    }

    @Override
    public void addRequiredAction(RequiredAction requiredAction) {

    }

    @Override
    public void removeRequiredAction(RequiredAction requiredAction) {

    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String s) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String s) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String s) {

    }

    @Override
    public boolean isEmailVerified() {
        return false;
    }

    @Override
    public void setEmailVerified(boolean b) {

    }

    @Override
    public void setOtpEnabled(boolean b) {

    }

    @Override
    public void updateCredential(UserCredentialModel userCredentialModel) {

    }

    @Override
    public List<UserCredentialValueModel> getCredentialsDirectly() {
        return null;
    }

    @Override
    public void updateCredentialDirectly(UserCredentialValueModel userCredentialValueModel) {

    }

    @Override
    public Set<GroupModel> getGroups() {
        return null;
    }

    @Override
    public void joinGroup(GroupModel groupModel) {

    }

    @Override
    public void leaveGroup(GroupModel groupModel) {

    }

    @Override
    public boolean isMemberOf(GroupModel groupModel) {
        return false;
    }

    @Override
    public String getFederationLink() {
        return null;
    }

    @Override
    public void setFederationLink(String s) {

    }

    @Override
    public String getServiceAccountClientLink() {
        return null;
    }

    @Override
    public void setServiceAccountClientLink(String s) {

    }

    @Override
    public void addConsent(UserConsentModel userConsentModel) {

    }

    @Override
    public UserConsentModel getConsentByClient(String s) {
        return null;
    }

    @Override
    public List<UserConsentModel> getConsents() {
        return null;
    }

    @Override
    public void updateConsent(UserConsentModel userConsentModel) {

    }

    @Override
    public boolean revokeConsentForClient(String s) {
        return false;
    }

    @Override
    public Set<RoleModel> getRealmRoleMappings() {
        return null;
    }

    @Override
    public Set<RoleModel> getClientRoleMappings(ClientModel clientModel) {
        return null;
    }

    @Override
    public boolean hasRole(RoleModel roleModel) {
        return false;
    }

    @Override
    public void grantRole(RoleModel roleModel) {

    }

    @Override
    public Set<RoleModel> getRoleMappings() {
        return null;
    }

    @Override
    public void deleteRoleMapping(RoleModel roleModel) {

    }
}
