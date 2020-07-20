package com.mhcl.particleanm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mhcl.particleanm.util.PrintUtil;
import com.mhcl.particleanm.util.ReadFileUtil;

public class ParticleAnimation {
	private static final Logger logger 
	  = LoggerFactory.getLogger(ParticleAnimation.class);
	
	public static List<String> getAnimated(String init, int speed) {
		List<String> animationList = new ArrayList<>();
		if(init==null || init.isEmpty()) {
			logger.info("Initial Instance can not be null or empty.");
			return animationList;
		}
		char[] initCharArray= init.toCharArray();
		if(!isValidParticleChar(initCharArray)) {
			logger.info("Initial Particle should be L, R or dot.");
			return animationList;
		}
		String[] initArray = new String[initCharArray.length];
		for(int k=0; k<initArray.length; k++) {
			initArray[k] = Character.toString(initCharArray[k]);
		}
		String[] tempArray = new String[initArray.length];
		StringBuilder sb = new StringBuilder();
		int[] leftRightCnt = {0};
		//if all empty then don't need to enter with first time condition
		boolean isFirstTime = !isAllEmptyParticles(initCharArray);
		while(leftRightCnt[0] > 0 || isFirstTime) {
			isFirstTime = false;
			leftRightCnt[0] = 0;
			tempArray = new String[initArray.length];
		for(int i=0; i<initArray.length; i++) {
			if("R".equalsIgnoreCase(initArray[i]) || "L".equalsIgnoreCase(initArray[i])) {
				leftRightMovement(tempArray, i, initArray[i], 
						leftRightCnt, initArray.length, speed);
			} else if("RL".equalsIgnoreCase(initArray[i])) {
				leftRightMovement(tempArray, i, "R", 
						leftRightCnt, initArray.length, speed);
				leftRightMovement(tempArray, i, "L", 
						leftRightCnt, initArray.length, speed);
			}
		}
		sb = new StringBuilder();
		sb.append("\"");
		for(int j=0; j<initArray.length; j++) {
			if("R".equalsIgnoreCase(initArray[j]) || "L".equalsIgnoreCase(initArray[j])
					|| "RL".equalsIgnoreCase(initArray[j])) {
				//System.out.print("X");
				sb.append("X");
			} else {
				//System.out.print(".");
				sb.append(".");
			}
		}
		//System.out.print(",");
		sb.append("\",");
		animationList.add(sb.toString());
		//System.out.println();
		initArray = tempArray;
		}
		sb = new StringBuilder();
		sb.append("\"");
		for(int j=0; j<initArray.length; j++) {
			if("R".equalsIgnoreCase(initArray[j]) || "L".equalsIgnoreCase(initArray[j])
					|| "RL".equalsIgnoreCase(initArray[j])) {
				//System.out.print("X");
				sb.append("X");
			} else {
				//System.out.print(".");
				//sb.append(".");
				sb.append(".");
			}
		}
		sb.append("\"");
		animationList.add(sb.toString());
		return animationList;
	}
	
	private static void leftRightMovement(String[] tempArray, int i, String leftRight, 
			int[] leftRightCnt, int length, int speed) {
		leftRightCnt[0] += 1;
		if(tempArray[i] == null || tempArray[i].isEmpty()) {
			tempArray[i] = ".";
		}
		if(i+speed < length && leftRight.equalsIgnoreCase("R")) {
			if("L".equalsIgnoreCase(tempArray[i+speed])) {
				tempArray[i+speed] = "RL";
			} else {
				tempArray[i+speed] = "R";
			}
		} else if(i-speed >= 0 && leftRight.equalsIgnoreCase("L")) {
			if("R".equalsIgnoreCase(tempArray[i-speed])) {
				tempArray[i-speed] = "RL";
			} else {
				tempArray[i-speed] = "L";
			}
		} else {
			leftRightCnt[0] -= 1;
		}
	}
	
	private static boolean isValidParticleChar(char[] initCharArray) {
		for(char initChar : initCharArray) {
			if(!(initChar == 'L' || initChar == 'R' || initChar == '.')) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isAllEmptyParticles(char[] initCharArray) {
		for(char initChar : initCharArray) {
			if(!(initChar == '.')) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String init = "LRRL.LR.LRR.R.LRRL.";
    	int speed = 1;
    	try {
		String particleanmInput = "C:\\datafile\\particle-anm.txt";
		String[] inputArray = ReadFileUtil.readFile(particleanmInput).get(0).split(",");
		if(inputArray.length == 2) {
			init = inputArray[0];
			speed = Integer.parseInt(inputArray[1]);
		}
    	} catch (Exception e) {
    		
    	}
		List<String> animationList = getAnimated(init, speed);
		System.out.println();
		System.out.println(" Animation Results : ");
		PrintUtil.printAnimationList(animationList);
	}
}
