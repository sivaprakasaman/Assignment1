/*Andrew Sivaprakasam
  CS0441
  Assignment 1
  Description: This is an implementation of the ProfileInterface ADT
*/

package cs445.a1;

public class Profile implements ProfileInterface{
    private static final String DEFAULT_NAME = "";
    private static final String DEFAULT_ABOUT = "";
    private Set<ProfileInterface> FriendSet = new Set<ProfileInterface>();
    private String user,about;

    public Profile(){
        this(DEFAULT_NAME,DEFAULT_ABOUT);
    }

    public Profile(String username, String aboutme){

        user = DEFAULT_NAME;
        about = DEFAULT_ABOUT;

        if(username!=null){
            user = username;
        }

        if(aboutme!=null){
            about = aboutme;
        }

    }

    public void setName(String toSet) throws IllegalArgumentExceptions{

        if(toSet!=null){
            user = toSet;
        }
        else{
            throw new IllegalArgumentException("Invalid Name! ");
        }

    }

    public String getName(){

        return user;
    }

    public void setAbout(String abt){

        if(abt!=null){
            about = abt;
        }
        else{
            throw new IllegalArgumentException("Invalid About Me!");
        }
    }

    public String getAbout(){
        return about;
    }

    public boolean follow(ProfileInterface toFollow){
        boolean canFollow = true;

        if(toFollow == null){
            canFollow = false;
        }
        else if(toFollow!=null&&!(FriendSet.contains(toFollow))){
            FriendSet.add(toFollow);
            canFollow = true;
        }

        return canFollow;
    }

    public boolean unfollow(ProfileInterface toUnfollow){
        boolean canUnfollow = true;

        if(toUnfollow == null){
            canUnfollow = false;
        }

        else if(toUnfollow!=null&&(FriendSet.contains(toUnfollow))){
            FriendSet.remove(toUnfollow);
            canUnfollow = true;
        }

        return canUnfollow;
    }

    public ProfileInterface[] following(int howMany)
    {

        Object[] allFriends_O = FriendSet.toArray();
        ProfileInterface[] allFriends = new ProfileInterface[allFriends_O.length];
        int friendnum = FriendSet.getCurrentSize();
        int toReach=1;
        //Make sure within bounds in client!!
        for(int i = 0; i<friendnum;i++)
        {
            allFriends[i] = (ProfileInterface)allFriends_O[i];
        }

        if(howMany>friendnum){
             toReach = friendnum;
        }
        else{
            toReach = howMany;
        }
        //Put this here to prevent NullPointerException
        ProfileInterface[] toDisplay = new ProfileInterface[toReach];

        for(int i = 0;i<toReach;i++){
            toDisplay[i] = allFriends[i];
        }

        return toDisplay;
    }

    public int getFriendSize(){
        return FriendSet.getCurrentSize();
    }

    public ProfileInterface recommend(){

        Object[] allFriends_O = FriendSet.toArray();
        ProfileInterface[] allFriends = new ProfileInterface[FriendSet.getCurrentSize()];
        ProfileInterface toRecommend = null;

        for(int i = 0; i<FriendSet.getCurrentSize();i++)
        {
            allFriends[i] = (ProfileInterface)allFriends_O[i];
        }


        for(int i = 0; i<allFriends.length;i++) {

            ProfileInterface friend = allFriends[i];
            ProfileInterface[] f_o_f = friend.following(100);//This is probably not the best way to do this :(

            for (int j = 0; j < f_o_f.length; j++) {

                if (!(FriendSet.contains(f_o_f[j]))&&(this!=(Profile)f_o_f[j])) {
                    toRecommend = f_o_f[j];
                    break;
                }

            }
        }

        //Make a dataset of all friends' friends


        //Check that dataset to find the first friend that isn't in user's list
        //if none, return null
        return toRecommend;
    }


}
