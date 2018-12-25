//package com.zy.wanandroid.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.zy.wanandroid.R;
//import com.zy.wanandroid.model.Word;
//import com.zy.wanandroid.ui.NameActivity;
//
//import java.util.List;
//
//public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
//
//    private final LayoutInflater mInflater;
//    private final Context mContext;
//
//    private List<Word> mWords;
//
//    public WordListAdapter(Context context) {
//        this.mContext = context;
//        mInflater = LayoutInflater.from(context);
//    }
//
//
//    @Override
//    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
//        return new WordViewHolder(itemView);
//    }
//
//
//    @Override
//    public void onBindViewHolder(WordViewHolder holder, int position) {
//        if (mWords != null) {
//            Word current = mWords.get(position);
//            holder.wordItemView.setText(current.mWord);
//            holder.wordItemView.setOnClickListener(v -> {
//                Intent intent = new Intent(mContext, NameActivity.class);
//                mContext.startActivity(intent);
//            });
//        } else {
//            holder.wordItemView.setText("No Word");
//        }
//
//    }
//
//
//    public void setWords(List<Word> words) {
//        mWords = words;
//        notifyDataSetChanged();
//    }
//
//
//    @Override
//    public int getItemCount() {
//
//        if (mWords != null) {
//            return mWords.size();
//        } else {
//            return 0;
//        }
//
//    }
//
//
//    class WordViewHolder extends RecyclerView.ViewHolder {
//        private final TextView wordItemView;
//
//        private WordViewHolder(View itemView) {
//            super(itemView);
//            wordItemView = itemView.findViewById(R.id.textView);
//        }
//    }
//
//
//}
//
