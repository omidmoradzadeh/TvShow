package Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.facebook.rebound.ui.Util;
import com.iomdroid.tvshow.R;

import java.util.List;

import Component.ImageCache.ImageLoader;
import DTO.SearchMovie;
import DTO.Show;
import Utils.ImageUtil;


public class ShowGridAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<Show> listStorage;
    private Context context;
    Utils.ImageUtil imageUtil = new ImageUtil();

    public ShowGridAdapter(Context context, List<Show> customizedListView) {
        this.context = context;
        layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        try {
            ViewHolder listViewHolder;
            if (convertView == null) {
                listViewHolder = new ViewHolder();
                convertView = layoutinflater.inflate(R.layout.grid_view_item, parent, false);
                listViewHolder.imageInListView = (ImageView) convertView.findViewById(R.id.ivGridItem);
                convertView.setTag(listViewHolder);
            } else {
                listViewHolder = (ViewHolder) convertView.getTag();
            }

            ImageLoader imageLoader = new ImageLoader(context);
            imageLoader.DisplayImage(listStorage.get(position).getImage().getOriginal(), listViewHolder.imageInListView);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return convertView;
    }

    static class ViewHolder {
        ImageView imageInListView;
    }
}