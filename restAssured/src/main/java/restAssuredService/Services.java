package restAssuredService;


import restAssured.RestAssuredClass;


public class Services {



    private static final RestAssuredClass rest = new RestAssuredClass();

    public void getRestApiRunning()
    {
        rest.getRestApiUpRunning();
    }

    public void hitEndpointGet(String endPoint){

        rest.hitEndpointGet(endPoint);
    }

    public void returnAllUsers(){
        rest.returnAllUsers();
    }

    public void returnSingleUser(String userId){
        rest.returnSingleUser(userId);
    }

    public void userWrongId(String userId){
        rest.userWrongId(userId);
    }

    public void setHeaderAndContent(){
        rest.setHeaderAndContentForNewUser();
    }
    public void hitEndpointPost(String endPoint){

        rest.hitEndpointPost(endPoint);
    }

    public void newUserCheckInSystem(){
        rest.newUserCheckInSystem();
    }

    public void deleteUser(String userId){
        rest.deleteUser(userId);
    }

    public void confirmDelete(String userId){
        rest.confirmDelete(userId);
    }

    public void updateExistingUser(String newUserID){

        rest.updateExistingUser(newUserID);
    }

    public void shouldUpdateUser(){
        rest.shouldUpdateUser();
    }




}
