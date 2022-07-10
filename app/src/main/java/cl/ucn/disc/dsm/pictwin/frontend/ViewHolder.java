package cl.ucn.disc.dsm.pictwin.frontend;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * The View Holder.
 */
public static class ViewHolder extends RecyclerView.ViewHolder {

    protected TextView mine;

    protected TextView yours;

    public ViewHolder(View view) {
        super(view);
        this.mine = view.findViewById(R.id.rt_tv_mine);
        this.yours = view.findViewById(R.id.rt_tv_yours);
    }
}
