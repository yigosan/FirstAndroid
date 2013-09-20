package com.example.firstproject.fragments;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.firstproject.R;

public class PictureGaleryFragment extends Fragment {
	private View mMyView = null;
	ImageView img1 = null;
	Gallery gal1 = null;
	
	public PictureGaleryFragment() {
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	if(null == mMyView)
    	{
    		mMyView = inflater.inflate(R.layout.galerylayout, container, false);
    		gal1 = (Gallery)mMyView.findViewById(R.id.gallery1);
	        img1 = (ImageView)mMyView.findViewById(R.id.galeryimageView1);
	        gal1.setAdapter(new ImageAdapter(this.getActivity()));
	        //gal1.setAdapter(new GalleryAdapter(this.getActivity()));
	        gal1.setOnItemClickListener(new OnItemClickListener() {
	        	@Override
	        	public void onItemClick(AdapterView<?> arg0, View v1, int position, long id){
		        	switch(position)
		        	{
			        	case 0:{img1.setImageResource(R.drawable.ata1);break;}
			        	case 1:{img1.setImageResource(R.drawable.ata2);break;}
			        	case 2:{img1.setImageResource(R.drawable.ata3);break;}
			        	case 3:{img1.setImageResource(R.drawable.ata4);break;}
			        	
		        	}
	        	}
	        });
	        
    	}else{
    		container.removeView(mMyView);
    	}
    	return mMyView;
    }
    
    public class ImageAdapter extends BaseAdapter
    {
    	int mGalleryItemBackground;
    	private Context mContext;
    	private Integer[] mimagesId={R.drawable.ata1, R.drawable.ata2, R.drawable.ata3, R.drawable.ata4};
    	
    	public ImageAdapter(Context c)
    	{
    		mContext=c;
    		TypedArray attr=mContext.obtainStyledAttributes(R.styleable.Gallery);
    		mGalleryItemBackground = attr.getResourceId(R.styleable.Gallery_android_galleryItemBackground,0);
    		attr.recycle();
    	}
    	
    	@Override
    	public int getCount(){return mimagesId.length;}
    	@Override
    	public Object getItem(int position){return position;}
    	@Override
    	public long getItemId(int position){return position;}
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent){
    		ImageView imageview = new ImageView(mContext);
    		imageview.setImageResource(mimagesId[position]);
    		imageview.setLayoutParams(new Gallery.LayoutParams(160,110));
    		imageview.setScaleType(ImageView.ScaleType.FIT_XY);
    		imageview.setBackgroundResource(mGalleryItemBackground);
    		return imageview;
    	}
    	
    }
    
    public class GalleryAdapter extends BaseAdapter {

    	int galleryItem;
    	private Context mContext;
    	private GalleryConfig galleryConfig;
    	int mGalleryItemBackground;
    	
    	public GalleryAdapter(Context context) {
    		super();
    		this.mContext = context;
    		TypedArray attr= mContext.obtainStyledAttributes(R.styleable.Gallery);
    		mGalleryItemBackground = attr.getResourceId(R.styleable.Gallery_android_galleryItemBackground,0);
    		attr.recycle();
    		galleryConfig=new GalleryConfig();
    	}
    	@Override
    	public int getCount() {
    		return galleryConfig.getGallery_list().size();
    	}
    	@Override
    	public Object getItem(int position) {
    		return galleryConfig.getGallery_list().get(position);
    	}

    	@Override
    	public long getItemId(int position) {
    		return position;
    	}
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {
    		ImageView imageView=new ImageView(mContext);
    		Drawable image = loadImageFromURL(galleryConfig.getGallery_list().get(position));
    		imageView.setImageDrawable(image);
    		imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
    		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    		return imageView;
    	}
    	 private Drawable loadImageFromURL(String url)
    	    {
    	    try
    	    {
    	    InputStream is = this.OpenHttpConnection(url);
    	    // InputStream is = (InputStream) new URL(url).getContent();
    	    Drawable d = Drawable.createFromStream(is, "src");
    	    return d;
    	    }catch (Exception e) {
    	    System.out.println(e);
    	    return null;
    	    }
    	 }
    	 
    	 private InputStream OpenHttpConnection(String strURL)
    	            throws IOException {
    	        URLConnection conn = null;
    	        InputStream inputStream = null;
    	        URL url = new URL(strURL);
    	        conn = url.openConnection();
    	        HttpURLConnection httpConn = (HttpURLConnection) conn;
    	        httpConn.setRequestMethod("GET");
    	        httpConn.connect();
    	        if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
    	            inputStream = httpConn.getInputStream();
    	        }
    	        return inputStream;
    	    }

    }
    
    public class GalleryConfig {
    	private ArrayList<String> gallery_list=new ArrayList<String>();

    	public ArrayList<String> getGallery_list() {
    		return gallery_list;
    	}

    	public void setGallery_list(ArrayList<String> gallery_list) {
    		this.gallery_list = gallery_list;
    	}

    	public GalleryConfig()
    	{
    		gallery_list.add("http://www.ethemsulan.com/wp-content/uploads/ara.png");
    		gallery_list.add("http://www.ethemsulan.com/wp-content/uploads/cikti5.png");
    		// gallery_list.add("http://blog.fommy.com/wp-content/uploads/2008/10/android-wallpaper1_1024x768.png");
    		// gallery_list.add("http://www.buynetbookcomputer.com/android-netbook-images/android-netbook-big.jpg");
    		// gallery_list.add("http://www.sharepointhoster.com/wp-content/uploads/2011/03/android_apps.jpeg");
    		// gallery_list.add("http://www.ethemsulan.com/wp-content/uploads/customList.png");
    		// gallery_list.add("http://www.ethemsulan.com/wp-content/uploads/handler.png");
    		// gallery_list.add("http://www.ethemsulan.com/wp-content/uploads/xml.png");
    		// gallery_list.add("http://www.ethemsulan.com/wp-content/uploads/progessbar.png");
    	}

    }
    	
}
