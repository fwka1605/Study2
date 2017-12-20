﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Data.Objects;
using System.Data.EntityClient;

namespace ConsoleApplication1
{
    public partial class AddressBookContainer : ObjectContext
    {
        public const string ConnectionString = "name=AddressBookContainer";
        public const string ContainerName = "AddressBookContainer";
    
        #region Constructors
    
        public AddressBookContainer()
            : base(ConnectionString, ContainerName)
        {
            this.ContextOptions.LazyLoadingEnabled = true;
        }
    
        public AddressBookContainer(string connectionString)
            : base(connectionString, ContainerName)
        {
            this.ContextOptions.LazyLoadingEnabled = true;
        }
    
        public AddressBookContainer(EntityConnection connection)
            : base(connection, ContainerName)
        {
            this.ContextOptions.LazyLoadingEnabled = true;
        }
    
        #endregion
    
        #region ObjectSet Properties
    
        public ObjectSet<Category> Categories
        {
            get { return _categories  ?? (_categories = CreateObjectSet<Category>("Categories")); }
        }
        private ObjectSet<Category> _categories;
    
        public ObjectSet<Entry> Entries
        {
            get { return _entries  ?? (_entries = CreateObjectSet<Entry>("Entries")); }
        }
        private ObjectSet<Entry> _entries;

        #endregion
    }
}
