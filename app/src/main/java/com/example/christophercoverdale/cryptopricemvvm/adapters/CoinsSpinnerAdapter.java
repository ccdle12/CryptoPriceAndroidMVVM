package com.example.christophercoverdale.cryptopricemvvm.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.christophercoverdale.cryptopricemvvm.R;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;

import java.util.List;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class CoinsSpinnerAdapter extends ArrayAdapter<CoinModel>
{

    public CoinsSpinnerAdapter(@NonNull Context context, @LayoutRes int resource,
                               @NonNull List<CoinModel> objects)
    {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent)
    {
        return getCustomView(position, convertView);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent)
    {
        return getCustomView(position, convertView);
    }

    @NonNull
    private View getCustomView(final int position, @Nullable final View convertView)
    {
        ViewHolder holder;
        View view = convertView;

        if (view == null)
        {
            view = inflateView();
            TextView textView = view.findViewById(android.R.id.text1);
            holder = new ViewHolder(textView);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        CoinModel coinModel = getItem(position);
        holder.bind(coinModel.getSymbol());

        return view;
    }

    @NonNull
    private View inflateView()
    {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return inflater.inflate(R.layout.spinner_item, null);
    }

    private class ViewHolder
    {
        @NonNull
        private final TextView text;

        public ViewHolder(@NonNull final TextView text)
        {
            this.text = text;
        }

        public void bind(@NonNull final String text)
        {
            this.text.setText(text);
        }
    }
}
