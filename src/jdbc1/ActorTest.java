/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class ActorTest {
    
    public static void main(String [] args) throws SQLException{
        Actor act = new Actor();
        List<Actor> lst = act.fetchAllActors();
        for(Actor actor: lst){
            System.out.println(actor.toString());
        }
    }
}
