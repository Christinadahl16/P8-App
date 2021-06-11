<?php

namespace App\Http\Controllers;
use App\Models\Product;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index($id)
    {

         $items = Product::orderByDesc('updated_at')->where("farmer_id", $id)->get();

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
            'price' => 'required',
            'farmer_id' => 'required',
            'image' => 'required',
        ]);



        $imageStr =  $request->file('image');


        $mime_type = $imageStr->getClientOriginalExtension();


        $imageOriginalName = uniqid().".".$mime_type;
        $path = $request->file('image')->storeAs('public/', $imageOriginalName);




        $post = new Product;
        $post->name = $request['name'];
        $post->description = $request['description'];
        $post->price = $request['price'];
        $post->farmer_id = $request['farmer_id'];
        $post->image = $path;
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
         $item = Product::find($id);

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
                        'price' => 'required',
                        'farmer_id' => 'required',
                        'image' => 'required',
                    ]);



                    $imageStr =  $request->file('image');


                    $mime_type = $imageStr->getClientOriginalExtension();


                    $imageOriginalName = uniqid().".".$mime_type;
                    $path = $request->file('image')->storeAs('public/', $imageOriginalName);




                       $post = Product::find($id);
                    $post->name = $request['name'];
                    $post->description = $request['description'];
                    $post->price = $request['price'];
                    $post->farmer_id = $request['farmer_id'];
                    $post->image = $path;
                    $post->save();
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
       $Product = Product::find($id);

       $Product->delete();
    }
}
