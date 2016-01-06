package com.zyp.recordyoyo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.adapters.ListViewAdapter;
import com.zyp.recordyoyo.models.ViewContent;
import com.zyp.recordyoyo.utils.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeContent.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeContent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeContent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private View mHomeContent;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<ViewContent> mViewContentsList;
    private ListView mViewListView;
    private ListViewAdapter mListViewAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeContent.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeContent newInstance(String param1, String param2) {
        HomeContent fragment = new HomeContent();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeContent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mHomeContent = inflater.inflate(R.layout.fragment_home_content, null);
        if (mHomeContent != null) {
            mViewListView = (ListView) mHomeContent.findViewById(R.id.list_view);
            mViewContentsList = setData();
            mListViewAdapter = new ListViewAdapter(this.getActivity().getApplicationContext(), mViewContentsList, "ViewContentsList");
            mViewListView.setAdapter(mListViewAdapter);
            Utility.setListViewHeightBasedOnChildren(mViewListView);
            //mListener.onFragmentInteraction(Uri.parse());
        }
        return mHomeContent;
    }


    private List<ViewContent> setData() {
        mViewContentsList = new ArrayList<ViewContent>();
        mViewContentsList.clear();
        ViewContent mViewContents;
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            mViewContents = new ViewContent();
            mViewContents.setTittleTxtView(i + "邵忠|心向未来，不同凡“想”");
            mViewContents.setCommentTxtView(i + "2016,我们需要前进");
            temp = i % 4;
            switch (temp) {
                case 0:
                    mViewContents.setImageViewId(R.mipmap.monkey_back_0);
                    break;
                case 1:
                    mViewContents.setImageViewId(R.mipmap.monkey_back_1);
                    break;
                case 2:
                    mViewContents.setImageViewId(R.mipmap.monkey_back_2);
                    break;
                case 3:
                    mViewContents.setImageViewId(R.mipmap.monkey_back_3);
                    break;
                default:
                    mViewContents.setImageViewId(R.mipmap.view_1);
                    break;

            }

            mViewContentsList.add(mViewContents);
        }
        return mViewContentsList;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
