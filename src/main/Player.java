package main;

import java.util.Date;

public interface Player {
    public String getName();
    public void setName(String firstName,String lastName);
    public Date getDOB();
    public Position getPreferredPosition();
    public void setPreferredPosition(String Position);
    public int getSkillLevel();
    public void setSkillLevel(int skillLevel);
}
