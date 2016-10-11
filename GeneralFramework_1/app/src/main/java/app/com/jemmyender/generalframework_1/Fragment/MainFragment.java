package app.com.jemmyender.generalframework_1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.com.jemmyender.generalframework_1.Adapter.RecyclerAdapter;
import app.com.jemmyender.generalframework_1.ContentActivity;
import app.com.jemmyender.generalframework_1.R;

/**
 * Created by Jemmy Ender on 2016/10/11.
 */
public class MainFragment extends Fragment implements RecyclerAdapter.ClickListener {

    public final static String ITEMS_COUNT_KEY = "PartThreeFragment$ItemsCount";
    private List<String> dataList;
    public static MainFragment createInstance(int itemsCount){
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RecyclerView recyclerView = (RecyclerView)inflater.inflate(R.layout.fragment_main,container,false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = createItemList();
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataList);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setClickListener(this);
    }

    @Override
    public void itemClick(View view, int position) {
        Toast.makeText(getActivity(), dataList.get(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putStringArrayListExtra("DATA_LIST",(ArrayList)dataList);
        intent.putExtra("PAGE_NUMBER",position);
        startActivity(intent);
    }

    private List<String> createItemList(){
        List<String>itemList = new ArrayList<>();
        Bundle bundle = getArguments();
        if(bundle != null){
            int itemsCount = bundle.getInt(ITEMS_COUNT_KEY);
            for(int i=0;i<itemsCount;i++){
                itemList.add("Item"+i);
            }
        }
        return itemList;
    }
}
