 package com.example.firstproject;  

 import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
 
 public class TabListener<T extends Fragment> implements ActionBar.TabListener {  
   private Fragment mFragment;  
   private final Activity mActivity;  
   private final String mTag;  
   private final Class<T> mClass;
   private final String mClassName;
   
   /** Constructor used each time a new tab is created.  
    * @param activity The host Activity, used to instantiate the fragment  
    * @param tag The identifier tag for the fragment  
    * @param clz The fragment's Class, used to instantiate the fragment  
    */  
   public TabListener(Activity activity, String tag, Class<T> clz) {  
     mActivity = activity;  
     mTag = tag;  
     mClass = clz;
     mClassName = "";  
   }
   
   public TabListener(Activity activity, String tag, String className) {  
	     mActivity = activity;  
	     mTag = tag;
	     mClass = null;
	     mClassName = className;  
	   }  
   /* The following are each of the ActionBar.TabListener callbacks */  
   public void onTabSelected(Tab tab, FragmentTransaction ft) {  
	   
	    mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);   // add this

	    if (mFragment == null){ // check to see if the fragment has already been initialized. If not create a new one. 
	        mFragment = Fragment.instantiate(mActivity, this.getClassName()); 
	        ft.add(android.R.id.content,mFragment,mTag); 
	    } else { 
	        ft.attach(mFragment); // if the fragment has been initialized attach it to the current activity 
	    }
	    
	    /*
	     *  Below is for the Sherlock implementation for compatibility with earlier Frameworks
	     *  
	    mFragment = mActivity.getSupportFragmentManager().findFragmentByTag(mTag);   // add this
    	if (mFragment == null){ // check to see if the fragment has already been initialized. If not create a new one. 
        	mFragment = android.support.v4.app.Fragment.instantiate(mActivity, mClass.getName()); 
        	ft.add(android.R.id.content,mFragment,mTag); 
    	} else { 
        	ft.attach(mFragment); // if the fragment has been initialized attach it to the current activity 
    	} 
	      
	     */

   }  
   public void onTabUnselected(Tab tab, FragmentTransaction ft) {  
     if (mFragment != null) {  
       // Detach the fragment, because another one is being attached  
       ft.detach(mFragment);  
     }  
   }  
   public void onTabReselected(Tab tab, FragmentTransaction ft) {  
     // User selected the already selected tab. Usually do nothing.  
   }  
   
   private String getClassName()
   {
	   if(null == this.mClass)
		   return this.mClassName;
	   else 
		   return this.mClass.getName();
   }
 }  