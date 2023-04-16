package com.example.userUi

import com.example.userDomain.UserData


data class UserDataView(
    val color: String,
    val id: Int,
    val name: String,
    val pantone_value: String,
    val year: Int,
)

fun UserData.toUserDataView() = UserDataView(
    color = color,
    id = id,
    name = name,
    pantone_value = pantone_value,
    year = year,
)
/*
* <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.example.loginUi.LoginFragment">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/email"
            android:padding="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toTopOf="@id/password"
            android:hint="email"
            android:gravity="center"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            android:text="@={viewmodel.email}" />

        <Button
            android:id="@+id/login"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            android:text="login"
            app:layout_constraintBottom_toBottomOf="parent"/>

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/password"
            android:padding="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="password"
            android:gravity="center"
            app:layout_constraintTop_toBottomOf="@id/email"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            android:text="@={viewmodel.password}" />

    </androidx.constraintlayout.widget.ConstraintLayout>
* */