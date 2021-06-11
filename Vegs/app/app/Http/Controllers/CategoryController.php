<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class CategoryController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {

    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request, [
            'name' => 'required',
            'description' => 'required',
            'cover_image' => 'image|nullable|max:1999',
        ]);

        if ($request->hasFile('cover_image')){
            $fileNameWithExt = $request->file('cover_image')->getClientOriginalImage();

            $fileName = pathInfo($fileNameWithExt, PATHINFO_FILENAME);

            $extention = $request->file('cover_image')->getOriginalExtention();

            $fileNameToStore = $fileName.'_'.time().'_'.$extention;

            $path = $request->file('cover_image')->storeAs('public/category/cover_images', $fileNameToStore);

        } else {
            $fileNameToStore = 'noimage.jpg';
        }

        $post = new Post;
        $post->name = $request['name'];
        $post->description = $request['description'];
        $post->user_id = Auth()->User()->id;
        $post->cover_image = $fileNameToStore;
        $post->save();

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
