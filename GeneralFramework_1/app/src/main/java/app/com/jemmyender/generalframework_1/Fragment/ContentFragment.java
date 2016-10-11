package app.com.jemmyender.generalframework_1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import app.com.jemmyender.generalframework_1.R;
import app.com.jemmyender.generalframework_1.Tools.Constants;

/**
 * Created by Jemmy Ender on 2016/10/11.
 */
public class ContentFragment extends Fragment {

    private static final String BUNDLE_KEY_1 = "DATA_STRING";
    private static final String BUNDLE_KEY_2 = "DATA_NUMBER";
    private String data;
    private int position;

    public ContentFragment(){}

    public static ContentFragment create(String data,int position){
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY_1, data);
        args.putInt(BUNDLE_KEY_2,position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        data = getArguments().getString(BUNDLE_KEY_1);
        position = getArguments().getInt(BUNDLE_KEY_2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        RelativeLayout relativeLayout = (RelativeLayout)view.findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(Constants.Color.get_Blue_Cyan(position));
        TextView textView = (TextView)view.findViewById(R.id.content);
        textView.setText(data);
        return view;
    }

}
