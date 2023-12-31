package com.tcs.fitnessappspringboot.tests;

import org.junit.jupiter.api.Test;

import com.tcs.fitnessappspringboot.entity.FollowedWorkout;
import com.tcs.fitnessappspringboot.entity.User;
import com.tcs.fitnessappspringboot.entity.Workout;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FollowedWorkoutsTest {

    @Test
    public void testGettersAndSetters() {
        
        Long followId = 1L;
        User user = new User();
        Workout workout = new Workout(); 
        LocalDate dateFollowed = LocalDate.of(2023, 1, 1);
        boolean completed = true;

		FollowedWorkout followedWorkout = new FollowedWorkout();
        followedWorkout.setFollowId(followId);
        followedWorkout.setUser(user);
        followedWorkout.setWorkout(workout);
        followedWorkout.setDateFollowed(dateFollowed);
        followedWorkout.setCompleted(completed);

   
        assertEquals(followId, followedWorkout.getFollowId());
        assertEquals(user, followedWorkout.getUser());
        assertEquals(workout, followedWorkout.getWorkout());
        assertEquals(dateFollowed, followedWorkout.getDateFollowed());
        assertEquals(completed, followedWorkout.isCompleted());
    }

    @Test
    public void testUserAssociation() {
       
        FollowedWorkout followedWorkout = new FollowedWorkout();
        User user = new User(); 

     
        followedWorkout.setUser(user);

     
        assertEquals(user, followedWorkout.getUser());
    }

    @Test
    public void testUserAssociationWithNull() {
     
        FollowedWorkout followedWorkout = new FollowedWorkout();

      
        followedWorkout.setUser(null);

       
        assertNull(followedWorkout.getUser());
    }

    @Test
    public void testWorkoutAssociation() {
        
        FollowedWorkout followedWorkout = new FollowedWorkout();
        Workout workout = new Workout();

        
        followedWorkout.setWorkout(workout);

    
        assertEquals(workout, followedWorkout.getWorkout());
    }

    @Test
    public void testWorkoutAssociationWithNull() {
     
        FollowedWorkout followedWorkout = new FollowedWorkout();

    
        followedWorkout.setWorkout(null);

  
        assertNull(followedWorkout.getWorkout());
    }
}
