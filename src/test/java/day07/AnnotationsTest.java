package day07;

import org.testng.annotations.*;

public class AnnotationsTest {

    @Test
    public void test1(){
        System.out.println("Test 1 Test");
    }

    @AfterMethod
    public void test2(){
        System.out.println("Test 2 AfterMethod");
    }

    @BeforeClass
    public void test3(){
        System.out.println("Test 3 BeforeClass");
    }

    @AfterTest
    public void test11(){
        System.out.println("Test 11 AfterTest");
    }
    @AfterSuite
    public void tes12(){
        System.out.println("Test 12 AfterSuite");
    }
    @BeforeTest
    public void test4(){
        System.out.println("Test 4 BeforeTest");
    }
    @AfterClass
    public void test5(){
        System.out.println("Test 5 AfterClass");
    }
    @BeforeSuite
    public void test6(){
        System.out.println("Test 6 BeforeSuite");
    }

    @Test
    public void test7(){
        System.out.println("Test 7 Test");
    }

    @BeforeTest
    public void test8() {
        System.out.println("Test 8 BeforeTest");
    }

    @AfterMethod
    public void test9(){
        System.out.println("Test 9 AfterMethod");
    }

    @BeforeMethod
    public void test10(){
        System.out.println("Test 10 BeforeMethod");
    }


}
