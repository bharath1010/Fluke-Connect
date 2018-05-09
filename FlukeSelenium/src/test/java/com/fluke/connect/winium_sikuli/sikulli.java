package com.fluke.connect.winium_sikuli;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class sikulli {

	Screen screen = new Screen();

	public  void sSetValue(String imagename, String data) 
	{
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename+ ".JPG");
		Pattern pattern = new Pattern(pathofthesikulipic);

		try {
			screen.type(pattern, data);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
   
	}

	public void sSetValue(String imagename, int data) {
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename+ ".JPG");
		Pattern pattern = new Pattern(pathofthesikulipic);
		try {
			screen.type(pattern, "" + data);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public  void sEditValue(String imagename, String Newdata) 
	{
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename+ ".JPG");
		Pattern pattern = new Pattern(pathofthesikulipic);

		try {
			screen.doubleClick(pattern);
			screen.type(pattern,Key.BACKSPACE);
			screen.type(pattern,Newdata);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
   
	}
	

	public  String sCopyPasteValue(String imagename) {
		String copiedData = null;
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename
				+ ".JPG");
		try {
			screen.doubleClick(pathofthesikulipic);
			screen.type("c", KeyModifier.CTRL);
			copiedData = (String) Toolkit.getDefaultToolkit()
					.getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copiedData;

	}

	public  void sClick(String imagename) {
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename+ ".JPG");
		@SuppressWarnings("unused")
		Pattern pattern = new Pattern(pathofthesikulipic);
		try {
			screen.click(pathofthesikulipic);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public  void sDoubleClick(String imagename)
	{
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename+ ".JPG");
		Pattern pattern = new Pattern(pathofthesikulipic);
		try {
			screen.doubleClick(pathofthesikulipic);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  boolean isImageExist(String imagename)
	{
		boolean flag=false;
		String pathofthesikulipic = Global.sikulipicpath.concat(imagename+ ".JPG");
		Pattern pattern = new Pattern(pathofthesikulipic);
		if (screen.exists(pattern) != null) 
		{
			flag=true;
		}
			return flag; 
	}

	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  ArrayList<String> getAllDropDownValue(String dropdownImageName,int lenthOfTheDropdown) {
		ArrayList lst = new ArrayList();
		try {
			String pathofthesikulipic = Global.sikulipicpath.concat(dropdownImageName+".JPG");
			Pattern pattern = new Pattern(pathofthesikulipic);
			Thread.sleep(1000);
			screen.click(pattern);
			screen.type(Key.DOWN);
			for (int i = 0; i <= lenthOfTheDropdown; i++) {
				Thread.sleep(1000);
				screen.type(Key.DOWN);

				screen.doubleClick(pattern);

				screen.type("x", KeyModifier.CTRL);

 				String data = (String) Toolkit.getDefaultToolkit()
						.getSystemClipboard().getData(DataFlavor.stringFlavor);

				lst.add(data);

				Thread.sleep(2000);
			}
			java.util.Iterator<String> itr = lst.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}


	public  int getDropdownSize(String dropdownImageName,String nameOfLastElement) {
		int lengthdb = 0;
		try {
			String pathofthesikulipic = Global.sikulipicpath
					.concat(dropdownImageName + ".JPG");
			Pattern pattern = new Pattern(pathofthesikulipic);

			screen.click(pattern);
			screen.type(Key.DOWN);
			lengthdb = 0;
			for (int i = 0; i <= 100; i++) {

				screen.type(Key.DOWN);

				screen.doubleClick(pattern);

				screen.type("x", KeyModifier.CTRL);

				String data11 = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				System.out.println(data11+ " data is selected from dropdown dropdown............");
				lengthdb = i;
				if (data11.equals(nameOfLastElement)) {
					break;
				}
			}
			System.out.println("dropdown length= " + lengthdb);
		} catch (Exception e) {
			e.printStackTrace();
		    }

		return lengthdb;
	}

	
	
	@SuppressWarnings("rawtypes")
	public  void selectDropDownValue(String dropdownImageName,String expectedOption ,int lengtOfDropdown) {
	
	@SuppressWarnings("unused")
	ArrayList lst = new ArrayList();
		try {
			String pathofthesikulipic = Global.sikulipicpath
					.concat(dropdownImageName + ".JPG");
			Pattern pattern = new Pattern(pathofthesikulipic);

		
		screen.click(pattern);
		screen.type(Key.DOWN);
		for (int i = 1; i <= lengtOfDropdown; i++) {
			for (int j = 0; j <= i; j++) {
			
				screen.type(Key.DOWN);
			}
			screen.doubleClick(pattern);

			screen.type("c", KeyModifier.CTRL);

			String actualData = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
					.getData(DataFlavor.stringFlavor);

			String expectedData = expectedOption;

			if (actualData.equals(expectedData)) {

				screen.type(Key.ENTER);
				break;
			     }
			screen.type(Key.BACKSPACE);

			
		     }
		
		

	} catch (Exception e) {
		e.printStackTrace();
	   }
	}	
		public void closeApplication(){
			sClick("close");
			
		}

}
