<?php

namespace App\Http\Controllers;
use App\Models\Farmer;
use App\Models\Product;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class FarmerController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {

         $items = Farmer::orderByDesc('updated_at')->get();

        foreach ($items as $message) {
                 if (Storage::exists($message->image)) {
                     $message->imageStr =  asset(Storage::url($message->image));
                 }
                else
                  $message->imageStr = "";
              }

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
            'name' => 'required',
            'description' => 'required',
            'image' => 'required',
        ]);

        $imageStr =  $request->file('image');

        $mime_type = $imageStr->getClientOriginalExtension();
        $imageOriginalName = uniqid().".".$mime_type;
        $path = $request->file('image')->storeAs('public/', $imageOriginalName);



        $post = new Farmer;
        $post->name = $request['name'];
        $post->description = $request['description'];
        $post->image = $path;
        $post->save();

        return $this->show($post->id);

    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
         $item = Farmer::find($id);

          if (Storage::exists($item->image))
              $item->imageStr =  asset(Storage::url($item->image));
          else
              $item->imageStr = "";

         return response($item);
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


            $this->validate($request, [
                    'name' => 'required',
                    'description' => 'required',
                    'image' => 'required',
                ]);



                $imageStr =  $request->file('image');

                $mime_type = $imageStr->getClientOriginalExtension();
                $imageOriginalName = uniqid().".".$mime_type;
                $path = $request->file('image')->storeAs('public/', $imageOriginalName);



                $post = Farmer::find($id);
                $post->name = $request['name'];
                $post->description = $request['description'];
                $post->image = $path;
                $post->save();

                return $this->show($id);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
       $Farmer = Farmer::find($id);

       $Farmer->delete();
    }
}
