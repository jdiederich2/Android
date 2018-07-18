package edu.cvtc.jdiederich2.infinitescroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ITEMS_PER_REQ = 20;
    private static final int TOTAL_ITEMS = 100;

    public RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private List<String> items;
    private int page;

    private static List<String> createItems() {
        List<String> items = new LinkedList<>();
        for(int i = 0; i < TOTAL_ITEMS; i++) {
            String prefix = i < 10 ? "0" : "";
            items.add("Item #" . concat(prefix) . concat(String.valueOf(i)));
        }
        return items;
    }

    private void initializeRecyclerView() {
        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(new InfiniteScrollAdapter(items.subList(page, ITEMS_PER_REQ)));
        this.recyclerView.addOnScrollListener(createScrollListener());
    }

    private InfiniteScrollListener createScrollListener() {
        return new InfiniteScrollListener(ITEMS_PER_REQ, this.layoutManager) {
            @Override
            public void onScrolledToEnd(int firstVisibleItemPosition) {
                // At the end of scroll view, populate new list. Requires api request
                // this.items fakes the request
                int start = ++page * ITEMS_PER_REQ;
                final boolean allItemsLoaded = start >= items.size();
                if(!allItemsLoaded) {
                    int end = start + ITEMS_PER_REQ;
                    final List<String> newItems = getItemsToBeLoaded(start, end);
                    refreshView(recyclerView, new InfiniteScrollAdapter( newItems ), firstVisibleItemPosition);
                }
            }
        };
    }

    private List<String> getItemsToBeLoaded(int start, int end) {
        List<String> newItems = items.subList(start, end);
        final List<String> oldItems = ((InfiniteScrollAdapter) recyclerView.getAdapter()).getItems();

        final List<String> list = new LinkedList<>();
        list.addAll(oldItems);
        list.addAll(newItems);
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.items = createItems();
        this.recyclerView = this.findViewById(R.id.item_list);
        this.initializeRecyclerView();
    }
}
