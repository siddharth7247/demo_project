package FragmentDemo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import com.example.demo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var btn11 : Button
    lateinit var btn12 : Button
    lateinit var btn13 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    return
                }
                parentFragmentManager.popBackStack()
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn11 = view.findViewById(R.id.btn11)
        btn12 = view.findViewById(R.id.btn12)
        btn13 = view.findViewById(R.id.btn13)

        btn11.setOnClickListener{
            val transition = childFragmentManager.beginTransaction()
            transition.replace(R.id.childFragmentContainer,Fragment_1_1())
            transition.addToBackStack(null)
            transition.commit()
        }
        btn12.setOnClickListener{
            val transition = childFragmentManager.beginTransaction()
            transition.replace(R.id.childFragmentContainer,Fragment_1_2())
            transition.addToBackStack(null)
            transition.commit()
        }
        btn13.setOnClickListener{
            val transition = childFragmentManager.beginTransaction()
            transition.replace(R.id.childFragmentContainer,Fragment_1_3())
            transition.addToBackStack(null)
            transition.commit()
        }
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}