package com.example.orderlist.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderlist.models.Supplier.orderlist
import kotlinx.android.synthetic.main.fragment_shipment.*
import kotlinx.android.synthetic.main.item_order.view.*
import com.example.orderlist.MainActivityViewModel
import com.example.orderlist.models.Order
import com.example.orderlist.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Shipment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Shipment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Shipment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private var orderAdapter : OrderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shipment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        //recyclerView = findViewById(R.id.rv_images)
        rv_order.setHasFixedSize(true)
        rv_order.layoutManager = layoutManager as RecyclerView.LayoutManager?
        orderAdapter = OrderAdapter(activity!!, orderlist)
    }

    override fun onStart() {
        super.onStart()
        rv_order.adapter = orderAdapter
    }

    private inner class OrderAdapter (val context : Context, val orders : Array <Order>) : RecyclerView.Adapter<OrderAdapter.MyViewHolder>() {

        lateinit var mainActivityViewModel : MainActivityViewModel

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return orders.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val order = orders[position]
            holder.setData(order, position)
        }

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var currentOrder: Order? = null
            var currentPosition: Int = 0

            init {

                itemView.setOnClickListener {

                    currentOrder?.let {

                        mainActivityViewModel = ViewModelProviders.of(activity!!).get(MainActivityViewModel::class.java!!)
                        //Log.d("Photo URL = ", photo.url)
                        mainActivityViewModel!!.setValue(currentPosition)

                        val manager = fragmentManager
                        val transaction = manager!!.beginTransaction()
                        val fragment = OrderDescription()
                        transaction.replace(R.id.fragment, fragment)
                        transaction.addToBackStack(null)
                        transaction.commit()

                    }
                }
            }

            fun setData(order: Order?, pos: Int) {
                order?.let {
                    itemView.tv_company_name.text = order.comapany_name
                    itemView.tv_pickup.text = order.pickup
                    itemView.tv_dropoff.text = order.dropoff
                }

                this.currentOrder = order
                this.currentPosition = pos
            }
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            //throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Shipment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Shipment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
