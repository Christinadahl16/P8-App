<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models;

class PostController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index($from, $to)
    {
        $items = Post::orderByDesc('updated_at')->skip($skip)->take($take)->with('category')->with('tag')->get();

        return response($items);
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
            'title' => 'required',
            'brief' => 'required',
            'description' => 'required',
            'category' => 'required',
            'cover_image' => 'image|nullable|max:1999',
        ]);

        if ($request->hasFile('cover_image')){
            $fileNameWithExt = $request->file('cover_image')->getClientOriginalImage();

            $fileName = pathInfo($fileNameWithExt, PATHINFO_FILENAME);

            $extention = $request->file('cover_image')->getOriginalExtention();

            $fileNameToStore = $fileName.'_'.time().'_'.$extention;

            $path = $request->file('cover_image')->storeAs('public/post/cover_images', $fileNameToStore);

        } else {
            $fileNameToStore = 'noimage.jpg';
        }

        $post = new Post;
        $post->title = $request['title'];
        $post->brief = $request['breif'];
        $post->description = $request['description'];
        $post->category_id = $request['category'];
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
