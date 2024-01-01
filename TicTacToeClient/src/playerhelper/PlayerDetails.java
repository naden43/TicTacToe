package playerhelper;

public class PlayerDetails {
    private String userName;
    private String name ;
    private String password;
    private int score ;
    private boolean status;
    private boolean isPlay;

    public boolean isStatus() {
        return status;
    }

    public boolean isIsPlay() {
        return isPlay;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIsPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
