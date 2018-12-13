/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class Actor {
    
    private long actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public Actor() {
    }

    public Actor(long actorId, String firstName, String lastName, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public List<Actor> fetchAllActors() throws SQLException{
        List<Actor> list = new ArrayList();
        Connection conn = MySQLConnection.connect();
        
        String sql = "select actor_id, first_name, last_name, last_update from actor";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            Actor actor = new Actor();
            actor.actorId = rs.getLong(1);
            actor.firstName = rs.getString(2);
            actor.lastName = rs.getString(3);
            actor.lastUpdate = rs.getDate(4); //.getObject(4, LocalDate.class);
            list.add(actor);
        }
        rs.close();
        pstmt.close();
        conn.close();
        
        return list;
    }
    
    
}
