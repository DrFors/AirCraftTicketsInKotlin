package codeasylum.ua.aircraftticket.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList

import codeasylum.ua.aircraftticket.R
import codeasylum.ua.aircraftticket.Ticket

/**
 * Created by Андрей on 20.11.2016.
 */

class CustomAdapter(context: Context, private val tickets: ArrayList<Ticket>) : ArrayAdapter<Ticket>(context, -1, tickets) {

    private class ViewHolder {
        internal var departureDate: TextView? = null
        internal var arrivalDate: TextView? = null
        internal var countOfTransfers: TextView? = null
        internal var price: TextView? = null
    }


    override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val viewHolder: ViewHolder

        if (convertView == null) {
            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.custom_list_view, parent, false)
            viewHolder.departureDate = convertView!!.findViewById(R.id.start_date) as TextView
            viewHolder.arrivalDate = convertView.findViewById(R.id.end_date) as TextView
            viewHolder.price = convertView.findViewById(R.id.price) as TextView
            viewHolder.countOfTransfers = convertView.findViewById(R.id.cout_of_transgers) as TextView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }


        viewHolder.departureDate!!.text = "Departure Date: " + tickets[i].startTime
        viewHolder.arrivalDate!!.text = "Arrival Date: " + tickets[i].endTime
        viewHolder.price!!.text = "Price: " + tickets[i].price
        viewHolder.countOfTransfers!!.text = "Transfers: " + tickets[i].numberOfTransfers



        return convertView
    }
}