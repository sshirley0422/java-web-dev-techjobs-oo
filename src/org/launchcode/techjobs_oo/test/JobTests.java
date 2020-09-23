package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTests {
    private Job testEmptyJobOne;
    private Job testEmptyJobTwo;
    private Job testFieldSettings;
    private Job testJobEquality;
    private Job testBlankObjects;
    private String jobBody;

    @Before
    public void init() {
        testEmptyJobOne = new Job();
        testEmptyJobTwo = new Job();
        testFieldSettings = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobEquality = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testBlankObjects = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        jobBody = "ID: 3\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence";
    }


    @Test
    public void emptyTest() {
    }

    @Test
    public void testSettingJobId() {
        assertFalse(testEmptyJobOne.equals(testEmptyJobTwo));
        assertEquals(1, testEmptyJobTwo.getId() - testEmptyJobOne.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testFieldSettings.getEmployer() instanceof Employer);
        assertTrue(testFieldSettings.getLocation() instanceof Location);
        assertTrue(testFieldSettings.getPositionType() instanceof PositionType);
        assertTrue(testFieldSettings.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester",testFieldSettings.getName());
        assertEquals("ACME",testFieldSettings.getEmployer().getValue());
        assertEquals("Desert",testFieldSettings.getLocation().getValue());
        assertEquals("Quality control",testFieldSettings.getPositionType().getValue());
        assertEquals("Persistence",testFieldSettings.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(testFieldSettings.equals(testJobEquality));
    }

    @Test
    public void testBlankLines(){
        assertEquals("\n" + jobBody + "\n",testFieldSettings.toString());
    }

    @Test
    public void testFieldData(){
        assertEquals("\nID: 3\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n",testFieldSettings.toString());
    }

    @Test
    public void testBlankFields(){
        assertEquals("\nID: 5\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n",testBlankObjects.toString());
    }

}
