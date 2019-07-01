package com.example.orderlist.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.orderlist.MainActivityViewModel
import com.example.orderlist.R
import com.example.orderlist.models.Supplier.orderlist
import kotlinx.android.synthetic.main.fragment_order_description.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OrderDescription.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OrderDescription.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class OrderDescription : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

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
        return inflater.inflate(R.layout.fragment_order_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivityViewModel : MainActivityViewModel = ViewModelProviders.of(activity!!).get(
            MainActivityViewModel::class.java!!)
        val pos = mainActivityViewModel.getValue()

        val orders = orderlist

        tvCompanyName.text = orders[pos].comapany_name
        tvPickup.text = orders[pos].pickup
        tvDestinationCompany.text = orders[pos].destination_company
        tvDropoff.text = orders[pos].dropoff
        tvBigTruck.text = orders[pos].bigTruck.toString()
        tvSmallTruck.text = orders[pos].smallTruck.toString()
        tvDate.text = orders[pos].date.toString()
        tvTime.text = orders[pos].time.toString()

        etBigTruckCost.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var s1 = etSmallTruckCost.text.toString().toIntOrNull()
                var s2 = etBigTruckCost.text.toString().toIntOrNull()

                if(s1 != null && s2 != null)
                    tvTotalCost.text = (s1.toInt() + s2.toInt()).toString()
                else
                    tvTotalCost.text = "0"
            }
        })

        etSmallTruckCost.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                var s1 = etSmallTruckCost.text.toString().toIntOrNull()
                var s2 = etBigTruckCost.text.toString().toIntOrNull()

                if(s1 != null && s2 != null)
                    tvTotalCost.text = (s1.toInt() + s2.toInt()).toString()
                else
                    tvTotalCost.text = "0"
            }
        })


        buttonBid.setOnClickListener {
            Toast.makeText(activity!!, "Successfully Bidded", Toast.LENGTH_LONG)
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
         * @return A new instance of fragment OrderDescription.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderDescription().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
