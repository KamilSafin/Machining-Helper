package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Fragments.ThreadsFragment;
import com.example.kamil.machininghelper.Model.Threads;
import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class ThreadsAdapter extends RecyclerView.Adapter<ThreadsAdapter.ThreadsHolder> {

    private Context mContext;
    private List<Threads> mThreads;

    public ThreadsAdapter(Context context, List<Threads> threads) {
        mContext = context;
        mThreads = threads;
    }

    @Override
    public ThreadsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_thread, parent, false);

        return new ThreadsHolder(view);
    }

    @Override
    public void onBindViewHolder(ThreadsHolder holder, int position) {
        holder.bindView(mThreads.get(position));
    }

    @Override
    public int getItemCount() {
        return mThreads.size();
    }

    class ThreadsHolder extends RecyclerView.ViewHolder{

        private TextView mThreadText;

        private Threads mThread;

        public ThreadsHolder(View itemView) {
            super(itemView);

            mThreadText = (TextView) itemView.findViewById(R.id.thread_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ThreadsFragment.setHoleDiameter(mThread);
                }
            });
        }

        public void bindView(Threads thread){
            mThread = thread;
            mThreadText.setText(mThread.getThreadName());
        }
    }
}
