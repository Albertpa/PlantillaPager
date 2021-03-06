package com.example.rodalies;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends FragmentActivity {

	//private static final String[] fragmentTags = { "Page1", "Page2" };	
	private ArrayAdapter<String> adapt;
	
	
    TabHost mTabHost;
    ViewPager  mViewPager;
    
    //clase que mezcla tabhost con pageview
    TabsAdapter mTabsAdapter;	
    
    private SharedPreferences sharedSettings;
    private boolean existPreferences = true;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sharedSettings = getSharedPreferences(Constants.RODA_PREFERENCES, Context.MODE_PRIVATE);
		
		
		if (!(sharedSettings.contains(Constants.LINEA_PRINCIPAL))) {
			Log.e("Rodalies", "no te shared preferences");
			//no tiene preferencias, llamamos a la configuraci�n de la linea principal
			existPreferences=false;
			startActivity(new Intent(MainActivity.this, GuardarPreferencias.class));  
			
		}else{
			String[] fragmentTags = { "Page1", "Page2" };
			Log.e("Rodalies", "te sharedpreferences");
			existPreferences=true;
	
			//nombres de los tabs
			 String[] items_menu = {
				 	    getResources().getString(R.string.menu_page1),
		                getResources().getString(R.string.menu_page2)
		                };
		 
		 
		     mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		     mTabHost.setup();
	
		     mViewPager = (ViewPager)findViewById(R.id.pager);
	
		     mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);	 
		     
		    Bundle args = new Bundle();
		    args.putInt(Constants.LINEA_PRINCIPAL, sharedSettings.getInt(Constants.LINEA_PRINCIPAL,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA1) )
		    	args.putInt(Constants.LINEA_SECUNDARIA1, sharedSettings.getInt(Constants.LINEA_SECUNDARIA1,-1) );
		    	
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA2) )
		    	args.putInt(Constants.LINEA_SECUNDARIA2, sharedSettings.getInt(Constants.LINEA_SECUNDARIA2,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA3) )
		    	args.putInt(Constants.LINEA_SECUNDARIA3, sharedSettings.getInt(Constants.LINEA_SECUNDARIA3,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA4) )
		    	args.putInt(Constants.LINEA_SECUNDARIA4, sharedSettings.getInt(Constants.LINEA_SECUNDARIA4,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA5) )
		    	args.putInt(Constants.LINEA_SECUNDARIA5, sharedSettings.getInt(Constants.LINEA_SECUNDARIA5,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA6) )
		    	args.putInt(Constants.LINEA_SECUNDARIA6, sharedSettings.getInt(Constants.LINEA_SECUNDARIA6,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA7) )
		    	args.putInt(Constants.LINEA_SECUNDARIA7, sharedSettings.getInt(Constants.LINEA_SECUNDARIA7,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA8) )
		    	args.putInt(Constants.LINEA_SECUNDARIA8, sharedSettings.getInt(Constants.LINEA_SECUNDARIA8,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA9) )
		    	args.putInt(Constants.LINEA_SECUNDARIA9, sharedSettings.getInt(Constants.LINEA_SECUNDARIA9,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA10) )
		    	args.putInt(Constants.LINEA_SECUNDARIA10, sharedSettings.getInt(Constants.LINEA_SECUNDARIA10,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA11) )
		    	args.putInt(Constants.LINEA_SECUNDARIA11, sharedSettings.getInt(Constants.LINEA_SECUNDARIA11,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA12) )
		    	args.putInt(Constants.LINEA_SECUNDARIA12, sharedSettings.getInt(Constants.LINEA_SECUNDARIA12,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA13) )
		    	args.putInt(Constants.LINEA_SECUNDARIA13, sharedSettings.getInt(Constants.LINEA_SECUNDARIA13,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA14) )
		    	args.putInt(Constants.LINEA_SECUNDARIA14, sharedSettings.getInt(Constants.LINEA_SECUNDARIA14,-1) );
		    
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA15) )
		    	args.putInt(Constants.LINEA_SECUNDARIA15, sharedSettings.getInt(Constants.LINEA_SECUNDARIA15,-1) );
		     
		    if( sharedSettings.contains(Constants.LINEA_SECUNDARIA16) )
		    	args.putInt(Constants.LINEA_SECUNDARIA16, sharedSettings.getInt(Constants.LINEA_SECUNDARIA16,-1) );
		    
		     //Se le indica la clase en cada posicion del array, es decir para cada posicion tiene un texto ya
		     //pero necesita indicar la clase correspondiente
		     
		    //bucle for de la pagina
		    //for()
		     mTabsAdapter.addTab(mTabHost.newTabSpec(fragmentTags[0]).setIndicator(items_menu[0]),
		     		Page1Activity.class, args);
		     
		     mTabsAdapter.addTab(mTabHost.newTabSpec(fragmentTags[1]).setIndicator(items_menu[1]),
		     		Page2Activity.class, args);
		    
		    
	
		     //para que si gira, mantenga el tab activo
		     /*
		     if (savedInstanceState != null) {
		         mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		         Log.e("Rodalies","saved tag1"+savedInstanceState.getString("tab"));
		     }
		     */
		     
		
		}
		
		

	}
	 /*
	 @Override
	 protected void onSaveInstanceState(Bundle outState) {
		 //if(existPreferences){
		    Log.e("Rodalies","saved tag2"+mTabHost.getCurrentTabTag());
	        super.onSaveInstanceState(outState);
	        Log.e("Rodalies","saved tag3"+mTabHost.getCurrentTabTag());
	        
	        
	        outState.putString("tab", mTabHost.getCurrentTabTag());
	        
		 //}
	 }
    */
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId())
	    {
		    case R.id.action_settings:
		    	Log.e("Rodalies", "entra a settings");
				//no tiene preferencias, llamamos a la configuraci�n de la linea principal
				existPreferences=false;
				startActivity(new Intent(MainActivity.this, GuardarPreferencias.class));  
		     break;
		    
		 }
	     return true;
	}
	
	/*
    public void onListItemSelected(int index, String fragmentTag) {
			Log.i("Rodalies", "curiosos tags"+fragmentTag); // para ver los curiosos tags que crea el ViewPager, ver findFragment()
			
			int position = mTabHost.getCurrentTab();
			
	}
	*/
	
	
	
	 /**
     * This is a helper class that implements the management of tabs and all
     * details of connecting a ViewPager with associated TabHost.  It relies on a
     * trick.  Normally a tab host has a simple API for supplying a View or
     * Intent that each tab will show.  This is not sufficient for switching
     * between pages.  So instead we make the content part of the tab host
     * 0dp high (it is not shown) and the TabsAdapter supplies its own dummy
     * view to show as the tab content.  It listens to changes in tabs, and takes
     * care of switch to the correct paged in the ViewPager whenever the selected
     * tab changes.
     */
	//Esta clase ayuda la mezcla de PAger con TabHost
    public static class TabsAdapter extends FragmentPagerAdapter
            implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final TabHost mTabHost;
        private final ViewPager mViewPager;
        private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

        static final class TabInfo { //esta peque�a clase guarda info de cada tab
            private final String tag;
            private final Class<?> clss;
            private final Bundle args;

            TabInfo(String _tag, Class<?> _class, Bundle _args) {
                tag = _tag;
                clss = _class;
                args = _args;
            }
        }

        static class DummyTabFactory implements TabHost.TabContentFactory {
            private final Context mContext;

            public DummyTabFactory(Context context) {
                mContext = context;
            }

            @Override
            public View createTabContent(String tag) {
                View v = new View(mContext);
                v.setMinimumWidth(0);
                v.setMinimumHeight(0);
                return v;
            }
        }

        public TabsAdapter(FragmentActivity activity, TabHost tabHost, ViewPager pager) {
            super(activity.getSupportFragmentManager());
            mContext = activity;
            mTabHost = tabHost;
            mViewPager = pager;
            mTabHost.setOnTabChangedListener(this);
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
            tabSpec.setContent(new DummyTabFactory(mContext));
            String tag = tabSpec.getTag();

            TabInfo info = new TabInfo(tag, clss, args);
            mTabs.add(info);
            mTabHost.addTab(tabSpec);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public Fragment getItem(int position) {
            TabInfo info = mTabs.get(position);
            return Fragment.instantiate(mContext, info.clss.getName(), info.args);
        }
        
        public Fragment findFragment(int position) {
            String name = "android:switcher:" + mViewPager.getId() + ":" + position; // curiosos tags
            FragmentManager fm = ((FragmentActivity) mContext).getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag(name);
            if (fragment == null) {
                fragment = getItem(position);
            }
            return fragment;
        }        

        @Override
        public void onTabChanged(String tabId) {
            int position = mTabHost.getCurrentTab();
            mViewPager.setCurrentItem(position);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            // Unfortunately when TabHost changes the current tab, it kindly
            // also takes care of putting focus on it when not in touch mode.
            // The jerk.
            // This hack tries to prevent this from pulling focus out of our
            // ViewPager.
            TabWidget widget = mTabHost.getTabWidget();
            int oldFocusability = widget.getDescendantFocusability();
            widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            mTabHost.setCurrentTab(position);
            widget.setDescendantFocusability(oldFocusability);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
               
    }

}
