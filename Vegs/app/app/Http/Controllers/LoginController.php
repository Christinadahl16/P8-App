<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;

class LoginController extends Controller
{



  // Checks the login and generated new token
  private function Checklogin($login)
  {
        if (!Auth::attempt($login))
        {
            return response(['error' => 'Invalid login credentials']);
        }

        $accessToken = Auth::user()->createToken('authToken')->plainTextToken;

        return response(['user' => Auth::user(), 'access_token' => $accessToken]);
  }


    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        $login = $request->validate([
            'email' => 'required|string',
            'password' => 'required|string',
        ]);

        return $this->Checklogin($login);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $register = $request->validate([
            'name' => 'required|string',
            'email' => 'required|email',
            'password' => 'required|string',
            'description' => 'nullable|string',
            'cover_image' => 'image|nullable|max:1999',
        ]);

        if ($request->hasFile('user_image')){
            $fileNameWithExt = $request->file('user_image')->getClientOriginalImage();

            $fileName = pathInfo($fileNameWithExt, PATHINFO_FILENAME);

            $extention = $request->file('user_image')->getOriginalExtention();

            $fileNameToStore = $fileName.'_'.time().'_'.$extention;

            $path = $request->file('user_image')->storeAs('public/users/user_image', $fileNameToStore);

        } else {
            $fileNameToStore = 'nouserimage.jpg';
        }

        $current = new \App\Models\User();

        if($current->where('email', $request['email'])->first() != null)
        {
         $login = $request->validate([
                    'email' => 'required|string',
                    'password' => 'required|string',
                ]);

                return $this->Checklogin($login);
          }

        $user = new \App\Models\User();
        $user->name = $request['name'];
        $user->password = Hash::make($request['password']);
        $user->email = $request['email'];
        $user->user_image = $fileNameToStore;
        $user->detail = $request['name'];

        if (!$user->save())
        {
            return response(['error' => 'Could not save user']);
        }

       $login = $request->validate([
            'email' => 'required|string',
            'password' => 'required|string',
        ]);

        return $this->Checklogin($login);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
