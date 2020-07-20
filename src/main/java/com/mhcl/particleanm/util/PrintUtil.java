package com.mhcl.particleanm.util;

import java.util.List;

public class PrintUtil {
	public static void printAnimationList(List<String> animationList) {
		if(animationList.size() == 1) {
			System.out.println("[" + animationList.get(0) + "]");
			return;
		}
		for(int i=0; i<animationList.size(); i++) {
			if(i==0) {
				System.out.println("[" + animationList.get(i));
			} else if(i == animationList.size()-1) {
				System.out.println(animationList.get(i) + "]");
			} else {
				System.out.println(animationList.get(i));
			}
		}
	}

}
