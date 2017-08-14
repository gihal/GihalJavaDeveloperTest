var path =require('path');
var ExtractTextPlugin = require("extract-text-webpack-plugin");


module.exports = {
    entry:{
       online_shop: "./src/js/online_shop.js",
       online_shop_summary: "./src/js/online_shop_summary.js" 
    },
    output:{
        path:path.resolve(__dirname,'dist'),
        filename: "[name].bundle.js",
        publicPath:'/dist'
    },
    module:{
        rules: [
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallbackLoader: "style-loader",
                    loader: 'css-loader'
                })
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin({
            filename:"online_shop.bundle.css",
            disabled:false,
            allChunks:true
        })
    ]
    
};