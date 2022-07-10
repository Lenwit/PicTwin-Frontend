package cl.ucn.disc.dsm.pictwin.frontend;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cl.ucn.disc.dsm.pictwin.frontend.model.Twin;
import cl.ucn.disc.dsm.pictwin.frontend.model.User;

/**
 * The Adapter of User.
 *
 * @author Mack Díaz.
 */
public final class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    /**
     * The User.
     */
    private User user;

    /**
     * The Constructor.
     */
    public UserAdapter() {
        //Nothing here
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View twinView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_twin, parent, false);
        return new ViewHolder(twinView);
    }

    /**
     * Called by RecyclerView tod siplay the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     *
     */
    @SuppressLint("DefaultLocate")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Retrieve the Twin at position
        final Twin twin = this.user.getTwins().get(position);

        //Update the GUI
        holder.mine.setText(String.format("ID: %d", twin.getMy().getId()));
        holder.yours.setText(String.format("ID: %d", twin.getYours().getId()));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {

        if (this.user == null) {
            return 0;
        }

        return this.user.getTwins().size();
    }

    /**
     * Set the User.
     */
    public void setUser(@NonNull User user) {this.user = user;}
}