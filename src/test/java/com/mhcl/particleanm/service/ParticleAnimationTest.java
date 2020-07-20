package com.mhcl.particleanm.service;

 
import java.util.ArrayList;
import java.util.List;

import com.mhcl.particleanm.util.PrintUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for ParticleAnimation
 */
public class ParticleAnimationTest  extends TestCase
{
    public ParticleAnimationTest( String testName )
    {
        super( testName );
    }
    
    protected void setUp() throws Exception {
    	super.setUp();
    	}
    
    protected void tearDown() throws Exception {
    	super.tearDown();
    	}
    
    public void testAnimationA()
    {
    	String init = "..R....";
    	int speed = 2;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    
    public void testAnimationB()
    {
    	String init = "RR..LRL";
    	int speed = 3;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    
    public void testAnimationC()
    {
    	String init = "LRLR.LRLR";
    	int speed = 2;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    
    public void testAnimationD()
    {
    	String init = "RLRLRLRLRL";
    	int speed = 10;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    
    public void testAnimationE()
    {
    	String init = "...";
    	int speed = 1;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    

    public void testAnimationF()
    {
    	String init = "LRRL.LR.LRR.R.LRRL.";
    	int speed = 1;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    
    public void testAnimationEmpty()
    {
    	String init = "";
    	int speed = 1;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
    
    public void testAnimationBadInput()
    {
    	String init = "LRKL.LR.LRR.R.LRRL.";
    	int speed = 1;
    	List<String> animationList = ParticleAnimation.getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
		System.out.println(" End Animation");
    }
}
