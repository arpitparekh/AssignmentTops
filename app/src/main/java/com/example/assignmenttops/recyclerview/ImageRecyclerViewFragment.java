package com.example.assignmenttops.recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentImageRecyclerViewBinding;
import com.example.assignmenttops.databinding.ImageRowItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageRecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageRecyclerViewFragment extends Fragment implements ImageAdapter.onImageClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ImageRecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageRecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageRecyclerViewFragment newInstance(String param1, String param2) {
        ImageRecyclerViewFragment fragment = new ImageRecyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentImageRecyclerViewBinding binding;
    private ImageAdapter adapter;
    private Image selectedImage;
    private ArrayList<Image> images;
    private ImageRowItemBinding binding1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentImageRecyclerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerViewImage.setLayoutManager(new GridLayoutManager(getContext(), 2));

        images = new ArrayList<>();
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/airplane.png"));
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"));
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/baboon.png"));
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/barbara.png"));
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/boat.png"));
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"));
        images.add(new Image("https://homepages.cae.wisc.edu/~ece533/images/tulips.png"));


        adapter = new ImageAdapter(images, this);

        binding.recyclerViewImage.setAdapter(adapter);
    }

    @Override
    public void onImageClick(int position) {


        Image selectedImage = images.get(position);

        Toast.makeText(getContext(), "Url is : " + selectedImage.getImageUrl(), Toast.LENGTH_SHORT).show();

    }


//    @Override
//    public void onRatingClick(int position) {
//       String rate= String.valueOf(binding1.ratingBar.getRating());
//        Toast.makeText(getContext(),"Url is : "+rate,Toast.LENGTH_SHORT).show();
//    }
}