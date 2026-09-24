package com.example.webviewmenuapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment

class ImagesFragment : Fragment() {

    private val selectedImages = mutableSetOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_images,
            container,
            false
        )

        val imageOptions =
            view.findViewById<Button>(R.id.btnImageOptions)

        val bottomActions =
            view.findViewById<View>(R.id.bottomActions)

        val shareButton =
            view.findViewById<Button>(R.id.btnShare)

        val editButton =
            view.findViewById<Button>(R.id.btnEdit)

        val deleteButton =
            view.findViewById<Button>(R.id.btnDelete)

        // All image views
        val images = listOf(
            view.findViewById<ImageView>(R.id.phoneImage1),
            view.findViewById<ImageView>(R.id.phoneImage2),
            view.findViewById<ImageView>(R.id.phoneImage3),
            view.findViewById<ImageView>(R.id.storageImage1),
            view.findViewById<ImageView>(R.id.storageImage2),
            view.findViewById<ImageView>(R.id.storageImage3),
            view.findViewById<ImageView>(R.id.urlImage1),
            view.findViewById<ImageView>(R.id.urlImage2),
            view.findViewById<ImageView>(R.id.urlImage3)
        )

        // Select individual image
        images.forEachIndexed { index, image ->

            image.setOnClickListener {

                if (selectedImages.contains(index)) {
                    selectedImages.remove(index)
                    image.alpha = 1.0f
                } else {
                    selectedImages.add(index)
                    image.alpha = 0.6f
                }

                bottomActions.visibility =
                    if (selectedImages.isNotEmpty())
                        View.VISIBLE
                    else
                        View.GONE
            }
        }

        // Image Options popup
        imageOptions.setOnClickListener {

            val popup = PopupMenu(
                requireContext(),
                imageOptions
            )

            popup.menu.add("Select All")
            popup.menu.add("Share")
            popup.menu.add("Edit")
            popup.menu.add("Delete")

            popup.setOnMenuItemClickListener { item ->

                when (item.title.toString()) {

                    "Select All" -> {

                        selectedImages.clear()

                        images.forEachIndexed { index, image ->
                            selectedImages.add(index)
                            image.alpha = 0.6f
                        }

                        bottomActions.visibility = View.VISIBLE
                    }

                    "Share" -> {

                        Toast.makeText(
                            requireContext(),
                            "Images shared",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    "Edit" -> {

                        Toast.makeText(
                            requireContext(),
                            "Edit selected images",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    "Delete" -> {

                        Toast.makeText(
                            requireContext(),
                            "Delete selected images",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                true
            }

            popup.show()
        }

        // Bottom Share
        shareButton.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Images shared",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Bottom Edit
        editButton.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Edit selected images",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Bottom Delete
        deleteButton.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Delete selected images",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}