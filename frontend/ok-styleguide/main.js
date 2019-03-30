function OKStyle ()
{
  this.plugins = [];
}

OKStyle.prototype.init = function ()
{
  this.plugins.forEach(plugin => {
    plugin.init(OKStyle);
  });
};

OKStyle.prototype.registerPlugin = function(plugin)
{
  this.plugins.push(plugin);
};